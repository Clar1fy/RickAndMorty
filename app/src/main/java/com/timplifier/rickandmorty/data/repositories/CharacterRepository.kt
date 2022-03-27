package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.remote.apiservices.CharactersApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService,
) : BaseRepository() {

    fun fetchCharacters(page: Int) = sendRequest {
        charactersApiService.fetchCharacters(page)
    }

    fun fetchSingleCharacter(id: Int) = sendRequest {
        charactersApiService.fetchSingleCharacter(id)
    }
}
