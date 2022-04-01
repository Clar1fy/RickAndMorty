package com.timplifier.rickandmorty.data.local.db.converters

import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

class LocationConverter {

    fun fromResidents(residents: List<RickAndMortyCharacter>): String =
        residents.joinToString(separator = ",")
}