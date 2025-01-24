package com.example.rickandmortywithcompose.data.dto.models.character


import com.google.gson.annotations.SerializedName


data class InfoCharacter(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String?=null,
    @SerializedName("prev")
    val prev: String?= null
)