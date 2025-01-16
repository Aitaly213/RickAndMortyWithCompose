package com.example.rickandmortywithcompose.data.models.location


import com.google.gson.annotations.SerializedName


data class BaseResponseLocation(
    @SerializedName("info")
    val infoLocation: InfoLocation,
    @SerializedName("results")
    val locationModels: List<LocationModel>
)