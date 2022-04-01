package com.timplifier.rickandmorty.data.remote.dtos.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

@Entity(tableName = "characters")

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
    @ColumnInfo(name = "species related to a character")
    @SerializedName("species")
    val species: String,
    @ColumnInfo(name = "character's type")
    @SerializedName("type")
    val type: String,
    @ColumnInfo(name = "character's gender")
    @SerializedName("gender")
    val gender: String,
    @ColumnInfo(name = "character's origin")
    @SerializedName("origin")
    val origin: Origin,
    @ColumnInfo(name = "character's location")
    @SerializedName("location")

    val location: Location,
    @ColumnInfo(name = "character's image")
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episodes: List<RickAndMortyEpisode>,
    @SerializedName("url")
    val url: String

) : BaseDiffModel