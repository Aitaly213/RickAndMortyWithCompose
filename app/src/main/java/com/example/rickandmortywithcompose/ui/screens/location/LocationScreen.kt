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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywithcompose.data.models.location.LocationModel

@Composable
fun LocationScreen(navigate: (name: String, type: String, dimension: String) -> Unit) {
    val mockDataLocationModels by remember {
        mutableStateOf(
            listOf(
                LocationModel(
                    id = 1,
                    name = "Earth (C-137)",
                    type = "Planet",
                    dimension = "Dimension C-137",
                    residents = listOf(
                        "https://rickandmortyapi.com/api/character/1",
                        "https://rickandmortyapi.com/api/character/2"
                    ),
                    url = "https://rickandmortyapi.com/api/location/1",
                    created = "2017-11-10T12:42:04.162Z"
                ),
                LocationModel(
                    id = 2,
                    name = "Abadango",
                    type = "Cluster",
                    dimension = "unknown",
                    residents = listOf(
                        "https://rickandmortyapi.com/api/character/6"
                    ),
                    url = "https://rickandmortyapi.com/api/location/2",
                    created = "2017-11-10T13:06:38.182Z"
                ),
                LocationModel(
                    id = 3,
                    name = "Citadel of Ricks",
                    type = "Space station",
                    dimension = "unknown",
                    residents = listOf(
                        "https://rickandmortyapi.com/api/character/8",
                        "https://rickandmortyapi.com/api/character/14"
                    ),
                    url = "https://rickandmortyapi.com/api/location/3",
                    created = "2017-11-10T13:08:13.191Z"
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
            items(mockDataLocationModels.size) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate(
                                mockDataLocationModels[index].name,
                                mockDataLocationModels[index].type,
                                mockDataLocationModels[index].dimension
                            )
                        }
                ) {


                    Text(
                        text = "Name: ${mockDataLocationModels[index].name}",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "type: ${mockDataLocationModels[index].type}",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Dimension: ${mockDataLocationModels[index].dimension}",
                        fontSize = 20.sp,
                        color = Color.Black, modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                }
            }
        }
    }
}

