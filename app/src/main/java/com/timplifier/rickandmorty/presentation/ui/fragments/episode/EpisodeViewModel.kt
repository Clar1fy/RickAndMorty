package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository
) : BaseViewModel() {
    var isLoading: Boolean = false
    private var page: Int = 0


    private val _episodesState = MutableLiveData<RickAndMortyResponse<RickAndMortyEpisode>>()
    var episodesState: LiveData<RickAndMortyResponse<RickAndMortyEpisode>> = _episodesState

    private val _episodesLocalState = MutableLiveData<List<RickAndMortyEpisode>>(
    )
    var episodesLocalState: LiveData<List<RickAndMortyEpisode>> = _episodesLocalState

    fun fetchCharacters() {

        isLoading = true
        episodesRepository.fetchEpisodes(page).subscribe(_episodesState) {
            page++
            isLoading = false
        }

    }

    fun getCharacters() = episodesRepository.()


    init {


        if (_episodesState.value == null) {
            fetchCharacters()
        }


    }

}