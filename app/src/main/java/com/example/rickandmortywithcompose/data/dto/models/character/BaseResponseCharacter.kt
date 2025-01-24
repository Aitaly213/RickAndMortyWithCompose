package com.example.rickandmortywithcompose.data.dto.models.character


import com.google.gson.annotations.SerializedName


data class BaseResponseCharacter(
    @SerializedName("info")
    val infoCharacter: InfoCharacter,
    @SerializedName("results")
    val characterModels: List<CharacterModel>
)