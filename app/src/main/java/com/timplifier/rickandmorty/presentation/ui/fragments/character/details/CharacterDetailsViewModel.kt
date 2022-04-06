package com.timplifier.rickandmorty.presentation.ui.fragments.character.details

import com.timplifier.rickandmorty.base.BaseViewModel
import com.timplifier.rickandmorty.data.repositories.CharacterRepository

class CharacterDetailsViewModel(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {

    fun fetchSingleCharacter(id: Int) =
        characterRepository.fetchSingleCharacter(id)


}