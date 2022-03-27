package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository
) : BaseViewModel() {
    var page: Int = 0
    var isLoading = false
    private val _episodesState = MutableLiveData<ArrayList<RickAndMortyEpisode>>()
    var episodesState: LiveData<ArrayList<RickAndMortyEpisode>> = _episodesState
    fun fetchEpisodes() {
        viewModelScope.launch {
            episodesRepository.fetchEpisodes(page).collect {

                when (it) {
                    is Resource.Loading -> {
                        isLoading = true
                    }
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Success -> {

                        _episodesState.postValue(it.data?.results)


                        page++
                    }
                }
            }

        }

    }

    init {
        _episodesState.value?.let {
            fetchEpisodes()
        }
    }
}