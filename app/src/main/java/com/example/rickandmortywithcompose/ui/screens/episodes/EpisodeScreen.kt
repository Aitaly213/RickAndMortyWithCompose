package com.example.rickandmortywithcompose.ui.screens.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywithcompose.data.dto.models.episode.EpisodeModel
import com.example.rickandmortywithcompose.ui.screens.character.CharacterViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodeScreen(
    navigate: (id: Int) -> Unit,
    episodeViewModel: EpisodeViewModel= koinViewModel<EpisodeViewModel>()
) {

    val episode by episodeViewModel.episodesState.collectAsState()


    LaunchedEffect(Unit) {
        episodeViewModel.fetchAllEpisodes()
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
            items(episode.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate(
                                episode[index].id
                            )
                        }


                ) {
                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {

                        Text(
                            text = episode[index].name.toString(),
                            fontSize = 20.sp,
                            color = Color.White
                        )

                        Row {
                            Text(
                                text = episode[index].airDate,
                                fontSize = 20.sp,
                                color = Color.White
                            )

                            Text(
                                text = " - ${episode[index].episode}",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }

                    }

                }
            }
        }
    }
}