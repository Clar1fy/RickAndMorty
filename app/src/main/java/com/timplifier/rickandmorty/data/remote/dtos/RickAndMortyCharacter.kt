package com.timplifier.rickandmorty.data.remote.dtos

data class RickAndMortyCharacter(
    @SerializedName("name")
    val name : String,
    @SerializedName("image")
    val image : String
)
