package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.local.db.daos.LocationDao
import com.timplifier.rickandmorty.data.remote.apiservices.LocationsApiService
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsApiService: LocationsApiService,
    private val locationDao: LocationDao
) : BaseRepository() {


    fun fetchLocations(page: Int) = sendRequest(

        { locationsApiService.fetchLocations(page) },

        { locations ->
            locationDao.insertLocations(*locations.results.toTypedArray())
        }
    )


    fun getCharacters() = sendRequest {

        locationDao.getLocations()
    }
}