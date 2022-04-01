package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.remote.apiservices.LocationsApiService
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsApiService: LocationsApiService
) : BaseRepository() {


    fun fetchLocations(page: Int) = sendRequest({
        locationsApiService.fetchEpisode()
    })
}