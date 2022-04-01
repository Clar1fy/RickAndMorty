package com.timplifier.rickandmorty.data.local.db.converters

import androidx.room.TypeConverter
import com.timplifier.rickandmorty.data.remote.dtos.character.Location
import com.timplifier.rickandmorty.data.remote.dtos.character.Origin
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

class CharacterConverter {
    @TypeConverter
    fun fromLocation(location: Location): String =

        location.name


    @TypeConverter
    fun fromOrigin(origin: Origin): String =

        origin.name

    @TypeConverter
    fun fromLocations(locations: List<RickAndMortyLocation>): String =
        locations.joinToString(separator = ",")

    @TypeConverter
    fun fromEpisodes(episodes: List<RickAndMortyEpisode>): String =
        episodes.joinToString(separator = ",")


}