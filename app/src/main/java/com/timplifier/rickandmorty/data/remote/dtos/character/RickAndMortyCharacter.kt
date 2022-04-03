package com.timplifier.rickandmorty.data.remote.dtos.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel


@Entity
data class RickAndMortyCharacter(
    @ColumnInfo(name = "character's id")
    @PrimaryKey(autoGenerate = false)
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
    @SerializedName("episode")
    val episodes: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : BaseDiffModel