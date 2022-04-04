package com.timplifier.rickandmorty.servicelocator

import com.timplifier.rickandmorty.presentation.ui.fragments.character.CharacterViewModel
import com.timplifier.rickandmorty.presentation.ui.fragments.character.details.CharacterDetailsViewModel
import com.timplifier.rickandmorty.presentation.ui.fragments.episode.EpisodeViewModel
import com.timplifier.rickandmorty.presentation.ui.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { CharacterDetailsViewModel(get()) }
}