package com.example.rickandmortywithcompose.ui.screens.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun CharacterDetailScreen(image:String,
                          name:String,
                          status:String,
                          species:String,
                          gender:String,
                          location:String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(all = 20.dp)
    ) {

        AsyncImage(model = image, contentDescription = "")


        Text(
            text = name,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = status,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = species,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = gender,
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = location,
            fontSize = 20.sp,
            color = Color.White
        )

    }
}