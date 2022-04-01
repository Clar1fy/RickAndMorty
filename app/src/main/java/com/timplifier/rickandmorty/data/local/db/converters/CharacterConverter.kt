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


    fun fromOrigin(origin: Origin): String =

        origin.name

    fun fromLocations(locations: List<RickAndMortyLocation>): String =
        locations.joinToString(separator = ",")

    fun fromEpisodes(episodes: List<RickAndMortyEpisode>): String =
        episodes.joinToString(separator = ",")


}