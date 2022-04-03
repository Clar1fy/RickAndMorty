package com.timplifier.rickandmorty.data.remote.dtos.character


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Origin(
    @ColumnInfo(name = "origin name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "origin url")
    @SerializedName("url")
    val url: String
)