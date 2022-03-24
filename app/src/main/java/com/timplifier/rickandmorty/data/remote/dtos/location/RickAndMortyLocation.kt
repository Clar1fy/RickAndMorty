package com.timplifier.rickandmorty.data.remote.dtos.location

import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

data class RickAndMortyLocation(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
) : BaseDiffModel