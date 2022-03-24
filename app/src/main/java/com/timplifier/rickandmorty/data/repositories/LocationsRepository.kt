package com.timplifier.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.timplifier.rickandmorty.data.remote.apiservices.LocationsApiService
import com.timplifier.rickandmorty.data.remote.pagingsources.LocationPagingSource
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsApiService: LocationsApiService
) {
    fun fetchLocations() = Pager(
        PagingConfig(pageSize = 20)
    ) {
        LocationPagingSource(locationsApiService)
    }.flow


}