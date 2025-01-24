package com.example.rickandmortywithcompose.ui.screens.location.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywithcompose.ui.screens.location.LocationViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LocationDetailScreen(
    id: Int,
    viewModel: LocationDetailViewModel = koinViewModel<LocationDetailViewModel>()
) {
    val location by viewModel.locationById.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchLocationById(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 20.dp)
    ) {

        Text(
            text = "Name: ${location?.name.toString()}",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "type: ${location?.type.toString()}",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "Dimension: ${location?.dimension.toString()}",
            fontSize = 20.sp,
            color = Color.Black

        )


    }
}