package com.timplifier.rickandmorty.data.remote.dtos.episode

import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

data class RickAndMortyEpisode(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    val episode: String
) : BaseDiffModel