package com.timplifier.rickandmorty.data.remote.apiservices

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import retrofit2.http.GET

interface EpisodesApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(): RickAndMortyResponse<RickAndMortyEpisode>
}