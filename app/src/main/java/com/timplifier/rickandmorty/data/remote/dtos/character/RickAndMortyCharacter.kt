package com.timplifier.rickandmorty.data.remote.dtos.character

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel
import com.timplifier.rickandmorty.data.local.db.converters.Converters


@Entity
data class RickAndMortyCharacter(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "character id")
    @SerializedName("id")
    override val id: Int,
    @ColumnInfo(name = "character's name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "character's status")
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @ColumnInfo(name = "character's type")
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("location")
    val location: Location,
    @ColumnInfo(name = "character's image")
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episodes: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : BaseDiffModel