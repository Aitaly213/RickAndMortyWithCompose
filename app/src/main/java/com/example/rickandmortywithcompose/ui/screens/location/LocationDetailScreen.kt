package com.example.rickandmortywithcompose.ui.screens.location

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

@Composable
fun LocationDetailScreen(name: String, type: String, dimension: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(all = 20.dp)
    ) {

        Text(
            text = "Name: $name",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "type: $type",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "Dimension: $dimension",
            fontSize = 20.sp,
            color = Color.Black

        )


    }
}