package com.timplifier.rickandmorty.data.remote.dtos.episode

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

@Entity
data class RickAndMortyEpisode(
    @ColumnInfo(name = "episode's id")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,
    @ColumnInfo(name = "episode's name")
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    @ColumnInfo(name = "episode's code")
    val episode: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : BaseDiffModel