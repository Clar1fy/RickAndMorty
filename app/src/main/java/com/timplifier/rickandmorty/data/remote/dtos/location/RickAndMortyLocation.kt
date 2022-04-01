package com.timplifier.rickandmorty.data.remote.dtos.location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

@Entity(tableName = "locations")
data class RickAndMortyLocation(

    @ColumnInfo(name = "location's id")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,
    @ColumnInfo(name = "location's name")
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    @ColumnInfo(name = "location's type")
    val type: String,
    @SerializedName("dimension")
    @ColumnInfo(name = "dimension where the location happened to be located")
    val dimension: String,
    @SerializedName("residents")
    val residents: List<RickAndMortyCharacter>

) : BaseDiffModel