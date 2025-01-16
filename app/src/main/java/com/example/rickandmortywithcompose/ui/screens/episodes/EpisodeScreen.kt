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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywithcompose.data.models.episode.EpisodeModel

@Composable
fun EpisodeScreen(
    navigate: (name: String, airDate: String, episode: String) -> Unit
) {

    val mockDataEpisodeModels by remember {
        mutableStateOf(
            listOf(
                EpisodeModel(
                    id = 1,
                    name = "Pilot",
                    airDate = "December 2, 2013",
                    episode = "S01E01",
                    characters = listOf(
                        "https://rickandmortyapi.com/api/character/1",
                        "https://rickandmortyapi.com/api/character/2"
                    ),
                    url = "https://rickandmortyapi.com/api/episode/1",
                    created = "2017-11-10T12:56:33.798Z"
                ),
                EpisodeModel(
                    id = 2,
                    name = "Lawnmower Dog",
                    airDate = "December 9, 2013",
                    episode = "S01E02",
                    characters = listOf(
                        "https://rickandmortyapi.com/api/character/1",
                        "https://rickandmortyapi.com/api/character/3"
                    ),
                    url = "https://rickandmortyapi.com/api/episode/2",
                    created = "2017-11-10T12:56:33.916Z"
                ),
                EpisodeModel(
                    id = 3,
                    name = "Anatomy Park",
                    airDate = "December 16, 2013",
                    episode = "S01E03",
                    characters = listOf(
                        "https://rickandmortyapi.com/api/character/1",
                        "https://rickandmortyapi.com/api/character/4"
                    ),
                    url = "https://rickandmortyapi.com/api/episode/3",
                    created = "2017-11-10T12:56:34.022Z"
                )
            )
        )
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
            items(mockDataEpisodeModels.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate( mockDataEpisodeModels[index].name,
                                 mockDataEpisodeModels[index].airDate,
                                 mockDataEpisodeModels[index].episode)
                        }


                ) {
                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {

                        Text(
                            text = mockDataEpisodeModels[index].name,
                            fontSize = 20.sp,
                            color = Color.White
                        )

                        Row {
                            Text(
                                text = mockDataEpisodeModels[index].airDate,
                                fontSize = 20.sp,
                                color = Color.White
                            )

                            Text(
                                text = " - ${mockDataEpisodeModels[index].episode}",
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