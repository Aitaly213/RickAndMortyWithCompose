package com.example.rickandmortywithcompose.ui.screens.episodes.detail

import android.util.Log
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
import com.example.rickandmortywithcompose.ui.screens.episodes.EpisodeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodeDetailScreen(
    id: Int,
    viewModel: EpisodeDetailViewModel= koinViewModel<EpisodeDetailViewModel>() ) {

    val episode by viewModel.episodeById.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchEpisodeById(id)
    }

    Log.e("aitaly", episode?.episode.toString() )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 20.dp)
    ) {

        Text(
            text = "Name:   ${episode?.name.toString()}",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "type:   ${episode?.airDate.toString()}",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "Dimension:   ${episode?.episode.toString()}",
            fontSize = 20.sp,
            color = Color.Black

        )


    }


}
