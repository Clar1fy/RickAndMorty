package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.timplifier.rickandmorty.common.extensions.fromJsonList
import com.timplifier.rickandmorty.data.remote.dtos.character.Location
import com.timplifier.rickandmorty.data.remote.dtos.character.Origin

class Converters {


    @TypeConverter
    fun locationToJson(value: Location?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String): Location = Gson().fromJson(value, Location::class.java)

    @TypeConverter
    fun originToJson(value: Origin?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToOrigin(value: String): Origin = Gson().fromJson(value, Origin::class.java)

    @TypeConverter
    fun listToJson(value: String?) = Gson().fromJsonList<List<String>>(value)


    @TypeConverter
    fun jsonToList(episodes: List<String>): String? = Gson().toJson(episodes)


}