package com.timplifier.rickandmorty.presentation.ui.fragments.location

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import com.timplifier.rickandmorty.data.repositories.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationsRepository: LocationsRepository
) : BaseViewModel() {
    var page: Int = 0
    var isLoading: Boolean = false
    private val _locationsState = MutableLiveData<ArrayList<RickAndMortyLocation>>()
    var locationState: LiveData<ArrayList<RickAndMortyLocation>> = _locationsState
    fun fetchLocations() {
        isLoading = true
        viewModelScope.launch {
            locationsRepository.fetchLocations(page).collect {
                when (it) {
                    is Resource.Loading -> {
                        isLoading = true
                    }
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Success -> {
                        isLoading = false
                        _locationsState.postValue(it.data?.results)
                        page++
                    }
                }
            }
        }
    }

    init {
        _locationsState.value?.let {
            fetchLocations()
        }
    }
}