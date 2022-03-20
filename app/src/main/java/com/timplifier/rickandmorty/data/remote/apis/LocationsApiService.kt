package com.timplifier.rickandmorty.data.remote.apis

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchEpisode(): RickAndMortyResponse<RickAndMortyLocation>
}