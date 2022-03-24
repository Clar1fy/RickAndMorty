package com.timplifier.rickandmorty.data.remote.apiservices

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchEpisode(@Query("page") page: Int): RickAndMortyResponse<RickAndMortyLocation>
}