package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

class LocationConverter {

    @TypeConverter
    fun fromResidents(residents: List<RickAndMortyCharacter>): String =
        residents.joinToString(separator = ",")
}