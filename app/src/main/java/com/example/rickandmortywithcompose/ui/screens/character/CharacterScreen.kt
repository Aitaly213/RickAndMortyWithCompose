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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.rickandmortywithcompose.data.dto.models.character.CharacterModel
import com.example.rickandmortywithcompose.data.dto.models.character.LocationCharacter
import com.example.rickandmortywithcompose.data.dto.models.character.Origin
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.component.getScopeName

@Composable
fun CharacterScreen(
    navigate: (
        id: Int
    ) -> Unit,
    charactersViewModel: CharacterViewModel = koinViewModel<CharacterViewModel>()
) {
   val characters by charactersViewModel.charactersState.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
        ) {
            items(characters.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .background(Color.DarkGray)
                        .clickable {
                            navigate(
                                characters[index].id
                            )
                        }
                ) {
                    AsyncImage(
                        model = characters[index].image,
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
                            text = characters[index].name,
                            fontSize = 20.sp,
                            color = Color.White
                        )


                        Row {
                            Text(
                                text = characters[index].status,
                                fontSize = 20.sp,
                                color = Color.White
                            )

                            Text(
                                text = " - ${characters[index].species}",
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

