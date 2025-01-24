package com.example.rickandmortywithcompose.ui.screens.character.detail

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
import coil3.compose.AsyncImage
import com.example.rickandmortywithcompose.ui.screens.character.CharacterViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharacterDetailScreen(
    id:Int,
    viewModel: CharacterDetailViewModel = koinViewModel<CharacterDetailViewModel>()
) {
    val character by viewModel.characterById.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchCharacterById(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(all = 20.dp)
    ) {

        AsyncImage(model = character?.image, contentDescription = "")


        Text(
            text = character?.name.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = character?.status.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = character?.species.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = character?.gender.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = character?.locationCharacter?.name.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}