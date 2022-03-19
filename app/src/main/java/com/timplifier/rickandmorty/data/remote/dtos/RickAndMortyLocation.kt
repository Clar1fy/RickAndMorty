package com.timplifier.rickandmorty.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class RickAndMortyLocation(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
)