package com.example.rickandmortywithcompose.ui.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.rickandmortywithcompose.ui.navRoute.NavRoute
import com.example.rickandmortywithcompose.ui.navRoute.TopLevelRoute
import com.example.rickandmortywithcompose.ui.screens.character.CharacterDetailScreen
import com.example.rickandmortywithcompose.ui.screens.character.CharacterScreen
import com.example.rickandmortywithcompose.ui.screens.episodes.EpisodeDetailScreen
import com.example.rickandmortywithcompose.ui.screens.episodes.EpisodeScreen
import com.example.rickandmortywithcompose.ui.screens.location.LocationDetailScreen
import com.example.rickandmortywithcompose.ui.screens.location.LocationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {


     val topLevelRoutes = listOf(
        TopLevelRoute("Character", NavRoute.Character, Icons.Filled.Face),
        TopLevelRoute("Episode", NavRoute.Episode, Icons.Filled.PlayArrow),
        TopLevelRoute("Location", NavRoute.Location, Icons.Filled.LocationOn)
    )

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route

            Log.e("aitaly", "currentRoute: ${currentRoute.toString()},")
            Log.e("aitaly", "tt ${topLevelRoutes[0].route.toString()}", )

            TopAppBar(title = {

                    topLevelRoutes.forEach {
                        if (currentRoute.toString() == it.route.toString()) {
                            Text(text =  it.name)
                        }
                    }

            })
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                topLevelRoutes.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any {
                            it.route == screen.route
                        } == true,
                        label = {
                            Text(text = screen.name)
                        },
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHostInit(navController)
        }
    }


}

//fun topBarTitle(currentRoute: String?): String {
//    topLevelRoutes.forEach {
//        if (currentRoute == it.route.toString()) {
//            return it.name
//        }
//
//    }
//    return ""
//}

@Composable
fun NavHostInit(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Character
    ) {

        composable<NavRoute.Character> {
            CharacterScreen(navigate = { image, name, status, species, gender, location ->
                navController.navigate(
                    NavRoute.CharacterDetails(
                        image = image, name = name, status = status,
                        species = species, gender = gender, location = location
                    )
                )
            }
            )
        }

        composable<NavRoute.CharacterDetails> {
            val args = it.toRoute<NavRoute.CharacterDetails>()

            CharacterDetailScreen(
                image = args.image,
                name = args.name,
                status = args.status,
                species = args.species,
                gender = args.gender,
                location = args.location
            )
        }

        composable<NavRoute.Episode> {
            EpisodeScreen(navigate = { name, airDate, episode ->
                navController.navigate(
                    NavRoute.EpisodeDetails(
                        name = name, airDate = airDate, episode = episode
                    )
                )
            }
            )

        }


        composable<NavRoute.EpisodeDetails> {
            val args = it.toRoute<NavRoute.EpisodeDetails>()

            EpisodeDetailScreen(
                name = args.name,
                airDate = args.airDate,
                episode = args.episode
            )
        }

        composable<NavRoute.Location> {
            LocationScreen(navigate = { name, type, dimension ->
                navController.navigate(
                    NavRoute.LocationDetails(
                        name = name, type = type, dimension = dimension
                    )
                )
            }
            )
        }

        composable<NavRoute.LocationDetails> {
            val args = it.toRoute<NavRoute.LocationDetails>()

            LocationDetailScreen(
                name = args.name,
                type = args.type,
                dimension = args.dimension
            )
        }

    }

}
