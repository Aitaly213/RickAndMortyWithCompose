package com.example.rickandmortywithcompose.ui.screens.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywithcompose.data.dto.models.location.LocationModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LocationScreen(
    navigate: (id: Int) -> Unit,
    locationViewModel: LocationViewModel = koinViewModel<LocationViewModel>()
) {

    val location by locationViewModel.locationState.collectAsState()

    LaunchedEffect(Unit) {
        locationViewModel.fetchAllLocations()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
        ) {
            items(location.size) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate(
                                location[index].id
                            )
                        }
                ) {


                    Text(
                        text = "Name: ${location[index].name}",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "type: ${location[index].type}",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Dimension: ${location[index].dimension}",
                        fontSize = 20.sp,
                        color = Color.White, modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                }
            }
        }
    }
}

