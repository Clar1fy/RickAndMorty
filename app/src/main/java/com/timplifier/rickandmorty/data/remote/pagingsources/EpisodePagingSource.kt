package com.timplifier.rickandmorty.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.timplifier.rickandmorty.common.constants.Constants.EPISODE_KEY
import com.timplifier.rickandmorty.data.remote.apiservices.EpisodesApiService
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import retrofit2.HttpException
import java.io.IOException

class EpisodePagingSource(private val episodesApiService: EpisodesApiService) :
    PagingSource<Int, RickAndMortyEpisode>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyEpisode> {
        val page = params.key ?: EPISODE_KEY
        return try {
            val response = episodesApiService.fetchEpisodes(page)
            val nextPageNumber = if (response.info.next == null) {

                null
            } else
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, RickAndMortyEpisode>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }
    }
}