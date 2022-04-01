package com.timplifier.rickandmorty.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import com.timplifier.rickandmorty.data.repositories.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationsRepository: LocationsRepository
) : BaseViewModel() {
    var isLoading: Boolean = false
    private var page: Int = 0
    private val _locationsState = MutableLiveData<RickAndMortyResponse<RickAndMortyLocation>>()
    var locationState: LiveData<RickAndMortyResponse<RickAndMortyLocation>> = _locationsState

    private val _localLocationState = MutableLiveData<List<RickAndMortyLocation>>()
    var localLocationState: LiveData<List<RickAndMortyLocation>> = _localLocationState


    fun fetchLocations() {
        isLoading = true
        locationsRepository.fetchLocations(page).subscribe(_locationsState) {
            page++
            isLoading = false
        }
    }
    fun getEpisodes() = locationsRepository.
}