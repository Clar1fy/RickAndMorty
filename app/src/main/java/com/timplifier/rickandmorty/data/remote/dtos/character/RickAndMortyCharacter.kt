package com.timplifier.rickandmorty.data.remote.dtos.character

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel


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
    @Embedded
    val origin: Origin,
    @SerializedName("location")
    @Embedded
    val location: Location,
    @ColumnInfo(name = "character's image")
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created : String
) : BaseDiffModel