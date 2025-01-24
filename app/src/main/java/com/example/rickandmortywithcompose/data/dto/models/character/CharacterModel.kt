package com.example.rickandmortywithcompose.data.dto.models.character


import com.google.gson.annotations.SerializedName


data class CharacterModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("location")
    val locationCharacter: LocationCharacter,
    @SerializedName("image")
    val image: String
)