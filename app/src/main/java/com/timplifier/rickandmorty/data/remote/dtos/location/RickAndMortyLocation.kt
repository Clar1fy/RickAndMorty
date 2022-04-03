package com.timplifier.rickandmorty.data.remote.dtos.location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.timplifier.rickandmorty.base.BaseDiffModel

@Entity
data class RickAndMortyLocation(


    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    @ColumnInfo(name = "location's type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String


) : BaseDiffModel