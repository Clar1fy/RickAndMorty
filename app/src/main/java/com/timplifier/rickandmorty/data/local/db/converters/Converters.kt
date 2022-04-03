package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.timplifier.rickandmorty.data.remote.dtos.character.Location
import com.timplifier.rickandmorty.data.remote.dtos.character.Origin

class Converters {
    private inline fun <reified T> typeToken() = object : TypeToken<T>() {}.type

    private inline fun <reified T> fromJson(value: String?): T {
        return Gson().fromJson(value, typeToken<T>())
    }

    private inline fun <reified T> toJson(generic: T): String? {
        return Gson().toJson(generic, typeToken<T>())
    }


    @TypeConverter
    fun locationToJson(value: Location?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String): Location = Gson().fromJson(value, Location::class.java)

    @TypeConverter
    fun originToJson(value: Origin?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToOrigin(value: String): Origin = Gson().fromJson(value, Origin::class.java)

    @TypeConverter
    fun listToJson(value: String?) = fromJson<List<String>>(value)

    @TypeConverter
    fun jsonToList(episodes: List<String>) = Gson().toJson(episodes)


}