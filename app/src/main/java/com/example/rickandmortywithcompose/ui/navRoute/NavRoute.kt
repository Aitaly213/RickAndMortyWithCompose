package com.example.rickandmortywithcompose.ui.navRoute

import kotlinx.serialization.Serializable

object NavRoute {

    @Serializable
    object Character

    @Serializable
    data class CharacterDetails(
        val id: Int
    )

    @Serializable
    object Episode

    @Serializable
    data class EpisodeDetails(
        val id: Int
    )

    @Serializable
    object Location

    @Serializable
    data class LocationDetails(
        val id: Int
    )

}
