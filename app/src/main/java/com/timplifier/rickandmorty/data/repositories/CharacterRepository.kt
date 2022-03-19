package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.apiservices.CharactersApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService
) {
    fun fetchCharacters() = liveData{

    }

}