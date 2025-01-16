package com.example.rickandmortywithcompose.ui.navRoute

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

object NavRoute {

    @Serializable
    object Character

    @Serializable
    data class CharacterDetails(
        val image: String,
        val name: String,
        val status: String,
        val species: String,
        val gender: String,
        val location: String
    )

    @Serializable
    object Episode

    @Serializable
    data class EpisodeDetails(
        val name: String,
        val airDate: String,
        val episode: String,
    )

    @Serializable
    object Location

    @Serializable
    data class LocationDetails(
        val name: String,
        val type: String,
        val dimension: String,
        )

}
