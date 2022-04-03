package com.timplifier.rickandmorty.data.remote.dtos.character


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Location(
    @ColumnInfo(name = "locationn name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "locationn url")
    @SerializedName("url")
    val url: String
)