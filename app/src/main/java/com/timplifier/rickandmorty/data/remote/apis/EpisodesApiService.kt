package com.timplifier.rickandmorty.data.remote.apis

import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import retrofit2.http.GET

interface EpisodesApiService {

    @GET("api/episodes")
    suspend fun fetchEpisodes(): RickAndMortyResponse<RickAndMortyEpisode>
}