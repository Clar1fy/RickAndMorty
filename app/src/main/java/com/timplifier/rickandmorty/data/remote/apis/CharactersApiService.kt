package com.timplifier.rickandmorty.data.remote.apis

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import retrofit2.http.GET

interface CharactersApiService {

    @GET("api/character")
    suspend fun fetchCharacters(): RickAndMortyResponse<RickAndMortyCharacter>
}