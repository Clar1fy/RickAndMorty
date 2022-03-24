package com.timplifier.rickandmorty.data.remote.dtos.character

import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

data class RickAndMortyCharacter(
    @SerializedName("id")
    override val id: Int,
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

    val location: Location,
    @SerializedName("image")
    val image: String,
) : BaseDiffModel