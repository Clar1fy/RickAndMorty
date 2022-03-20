package com.timplifier.rickandmorty.data.repositories

import androidx.lifecycle.liveData
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.apis.CharactersApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService
) {
    fun fetchCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(charactersApiService.fetchCharacters()))
        } catch (ioException: Exception) {
            emit(Resource.Error(null, ioException.localizedMessage))
        }

    }

}