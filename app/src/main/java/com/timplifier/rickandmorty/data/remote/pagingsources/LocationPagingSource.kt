package com.timplifier.rickandmorty.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.timplifier.rickandmorty.common.constants.Constants.LOCATION_KEY
import com.timplifier.rickandmorty.data.remote.apiservices.LocationsApiService
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.HttpException
import java.io.IOException

class LocationPagingSource(private val locationsApiService: LocationsApiService) :
    PagingSource<Int, RickAndMortyLocation>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyLocation> {
        val page = params.key ?: LOCATION_KEY
        return try {
            val response = locationsApiService.fetchEpisode(page)
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

    override fun getRefreshKey(state: PagingState<Int, RickAndMortyLocation>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}