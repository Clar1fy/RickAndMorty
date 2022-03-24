package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository
) : BaseViewModel() {
    fun fetchEpisodes() = episodesRepository.fetchEpisodes().cachedIn(viewModelScope)
}