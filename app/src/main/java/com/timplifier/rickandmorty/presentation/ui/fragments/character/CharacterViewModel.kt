package com.timplifier.rickandmorty.presentation.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {
    var isLoading: Boolean = false
    private var page: Int = 0

    private val _characterState = MutableLiveData<RickAndMortyResponse<RickAndMortyCharacter>>()
    var characterState: LiveData<RickAndMortyResponse<RickAndMortyCharacter>> = _characterState

    private val _characterLocalState = MutableLiveData<List<RickAndMortyCharacter>>()
    var characterLocalState: LiveData<List<RickAndMortyCharacter>> = _characterLocalState

    fun fetchCharacters() {

        isLoading = true
        characterRepository.fetchCharacters(page).gather(_characterState) {
            page++
            isLoading = false
        }

    }

    fun getCharacters() = characterRepository.getCharacters().gather(_characterLocalState)


}




