package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.local.db.daos.EpisodeDao
import com.timplifier.rickandmorty.data.remote.apiservices.EpisodesApiService

class EpisodesRepository(
    private val episodesApiService: EpisodesApiService,
    private val episodeDao: EpisodeDao
) : BaseRepository() {

    fun fetchEpisodes(page: Int) = sendRequest(

        { episodesApiService.fetchEpisodes(page) },

        { episodes ->
            episodeDao.insertEpisodes(*episodes.results.toTypedArray())
        }
    )


    fun getEpisodes() = sendRequest {

        episodeDao.getEpisodes()
    }
}