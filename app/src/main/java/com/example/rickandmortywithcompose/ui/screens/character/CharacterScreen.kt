package com.example.rickandmortywithcompose.ui.screens.character

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import coil3.compose.AsyncImage
import com.example.rickandmortywithcompose.data.models.character.CharacterModel
import com.example.rickandmortywithcompose.data.models.character.LocationCharacter
import com.example.rickandmortywithcompose.data.models.character.Origin

@Composable
fun CharacterScreen(navigate: (image: String
                               , name:String, status:String, species:String,
                               gender:String, location:String
        ) -> Unit) {

    val mockDataCharacterModels by remember {
        mutableStateOf(
            listOf(
                CharacterModel(
                    id = 0,
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    type = "",
                    gender = "Male",
                    origin = Origin(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/1"
                    ),
                    locationCharacter = LocationCharacter(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/20"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    episode = listOf(
                        "https://rickandmortyapi.com/api/episode/1",
                        "https://rickandmortyapi.com/api/episode/2"
                    ),
                    url = "https://rickandmortyapi.com/api/character/1",
                    created = "2017-11-04T18:48:46.250Z"
                ),
                CharacterModel(
                    id = 1,
                    name = "Morty Smith",
                    status = "Alive",
                    species = "Human",
                    type = "",
                    gender = "Male",
                    origin = Origin(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/1"
                    ),
                    locationCharacter = LocationCharacter(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/20"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                    episode = listOf(
                        "https://rickandmortyapi.com/api/episode/1",
                        "https://rickandmortyapi.com/api/episode/2"
                    ),
                    url = "https://rickandmortyapi.com/api/character/2",
                    created = "2017-11-04T18:50:21.651Z"
                ),
                CharacterModel(
                    id = 2,
                    name = "Summer Smith",
                    status = "Alive",
                    species = "Human",
                    type = "",
                    gender = "Female",
                    origin = Origin(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/1"
                    ),
                    locationCharacter = LocationCharacter(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/20"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
                    episode = listOf(
                        "https://rickandmortyapi.com/api/episode/6",
                        "https://rickandmortyapi.com/api/episode/7"
                    ),
                    url = "https://rickandmortyapi.com/api/character/3",
                    created = "2017-11-04T19:09:56.428Z"
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
            items(mockDataCharacterModels.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate(
                                mockDataCharacterModels[index].image,
                                mockDataCharacterModels[index].name,
                                mockDataCharacterModels[index].status,
                                mockDataCharacterModels[index].species,
                                mockDataCharacterModels[index].gender,
                                mockDataCharacterModels[index].locationCharacter.name
                                )
                        }
                ) {
                    AsyncImage(
                        model = mockDataCharacterModels[index].image,
                        contentDescription = "",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)


                    )

                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {

                        Text(
                            text = mockDataCharacterModels[index].name,
                            fontSize = 20.sp,
                            color = Color.White
                        )

                        Row {
                            Text(
                                text = mockDataCharacterModels[index].status,
                                fontSize = 20.sp,
                                color = Color.White
                            )

                            Text(
                                text = " - ${mockDataCharacterModels[index].species}",
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

