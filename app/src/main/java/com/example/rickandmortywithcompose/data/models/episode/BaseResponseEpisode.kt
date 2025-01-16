package com.example.rickandmortywithcompose.data.models.episode


import com.google.gson.annotations.SerializedName


data class BaseResponseEpisode(
    @SerializedName("info")
    val infoEpisode: InfoEpisode,
    @SerializedName("results")
    val episodeModels: List<EpisodeModel>
)