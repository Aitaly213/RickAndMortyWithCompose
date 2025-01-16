package com.example.rickandmortywithcompose.data.models.location


import com.google.gson.annotations.SerializedName


data class InfoLocation(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String?=null,
    @SerializedName("prev")
    val prev: String?=null
)