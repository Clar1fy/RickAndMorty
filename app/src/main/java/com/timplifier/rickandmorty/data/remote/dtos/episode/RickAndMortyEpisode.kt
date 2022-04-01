package com.timplifier.rickandmorty.data.remote.dtos.episode

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

@Entity(tableName = "episodes")
data class RickAndMortyEpisode(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    @ColumnInfo(name = "episode's name")
    val name: String,
    @ColumnInfo(name = "episode's air date")
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    @ColumnInfo(name = "episode's code")
    val episode: String,
    @SerializedName("characters")
    val characters: List<RickAndMortyCharacter>
) : BaseDiffModel