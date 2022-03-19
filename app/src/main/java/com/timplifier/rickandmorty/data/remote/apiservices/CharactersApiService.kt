package com.timplifier.rickandmorty.data.remote.apiservices

import retrofit2.http.GET

interface CharactersApiService {

    @GET("api/character")
    suspend fun fetchCharacters():
}