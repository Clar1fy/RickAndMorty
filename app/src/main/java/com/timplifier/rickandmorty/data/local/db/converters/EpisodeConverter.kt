package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

class EpisodeConverter {
    @TypeConverter
    fun fromCharacters(characters: List<RickAndMortyCharacter>): String =
        characters.joinToString(separator = ",")


}