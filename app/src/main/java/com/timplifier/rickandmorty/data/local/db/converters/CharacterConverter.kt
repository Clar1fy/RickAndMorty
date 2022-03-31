package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.timplifier.rickandmorty.data.remote.dtos.character.Location
import com.timplifier.rickandmorty.data.remote.dtos.character.Origin

class CharacterConverter {
    @TypeConverter
    fun fromLocation(location: Location): String {

        return location.name

    }

    fun fromOrigin(origin: Origin): String {

        return origin.name
    }
}