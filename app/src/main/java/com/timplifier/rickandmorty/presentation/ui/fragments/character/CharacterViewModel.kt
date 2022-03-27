package com.timplifier.rickandmorty.presentation.ui.fragments.character

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {
    var isLoading: Boolean = false
    private var page: Int = 0

    private val _characterState = MutableLiveData<ArrayList<RickAndMortyCharacter>>()
    var characterState: LiveData<ArrayList<RickAndMortyCharacter>> = _characterState
    fun fetchCharacters() =
        viewModelScope.launch {
            characterRepository.fetchCharacters(page).collect {
                when (it) {

                    is Resource.Loading -> {
                        isLoading = true
                    }
                    is Resource.Error -> {
                        Log.e("An Error in CharacterViewModel occurred", it.message.toString())
                    }
                    is Resource.Success -> {
                        isLoading = true

                        _characterState.postValue(it.data?.results)


                        page++
                    }
                }
            }
        }

    init {

        _characterState.value.let {
            fetchCharacters()
        }


    }

}

