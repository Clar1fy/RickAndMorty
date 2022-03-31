package com.timplifier.rickandmorty.data.repositories

import com.timplifier.rickandmorty.base.BaseRepository
import com.timplifier.rickandmorty.data.local.db.daos.CharacterDao
import com.timplifier.rickandmorty.data.remote.apiservices.CharactersApiService
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService,
    private val characterDao: CharacterDao
) : BaseRepository() {

    fun fetchCharacters(page: Int) = sendRequest(

        { charactersApiService.fetchCharacters(page) },

        { characters ->
            characterDao.insertCharacters(*characters.results.toTypedArray())
        }
    )


    fun fetchSingleCharacter(id: Int) = sendRequest {
        charactersApiService.fetchSingleCharacter(id)
    }

    suspend fun insertCharacters(characters: List<RickAndMortyCharacter>) =
        characterDao.insertCharacters(* characters.toTypedArray())


    fun getCharacters() = sendRequest {

        characterDao.getCharacters()
    }

}
