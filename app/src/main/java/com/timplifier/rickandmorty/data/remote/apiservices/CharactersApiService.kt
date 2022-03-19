package com.timplifier.rickandmorty.data.remote.apiservices

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyCharacter
import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import retrofit2.http.GET

interface CharactersApiService {

    @GET("api/character")
    suspend fun fetchCharacters(): RickAndMortyResponse<RickAndMortyCharacter>
}