package com.timplifier.rickandmorty.data.repositories

import androidx.lifecycle.liveData
import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.apiservices.CharactersApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService,
) : BaseRepository() {

    fun fetchCharacters(page: Int) = sendRequest {
        charactersApiService.fetchCharacters(page)
    }

    fun fetchSingleCharacter(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())



        try {
            emit(Resource.Success(charactersApiService.fetchSingleCharacter(id)))

        } catch (ioException: Exception) {
            emit(Resource.Error(null, ioException.localizedMessage))
        }
    }
}
