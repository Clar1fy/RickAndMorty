package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.remote.apiservices.EpisodesApiService
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApiService: EpisodesApiService
) : BaseRepository() {

    fun fetchEpisodes(page: Int) = sendRequest {
        episodesApiService.fetchEpisodes(page)
    }

}