package com.timplifier.rickandmorty.data.remote.dtos.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

@Entity
data class RickAndMortyEpisode(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    val episode: String
) : BaseDiffModel