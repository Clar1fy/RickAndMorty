package com.timplifier.rickandmorty.presentation.ui.fragments.location

import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.repositories.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationsRepository: LocationsRepository
) : BaseViewModel() {
    fun fetchLocations() = locationsRepository.fetchLocations()
}