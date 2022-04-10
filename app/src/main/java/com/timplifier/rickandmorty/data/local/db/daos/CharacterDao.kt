package com.timplifier.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(vararg characters: RickAndMortyCharacter)

    @Query("SELECT * FROM rickandmortycharacter")
    fun getCharacters(): List<RickAndMortyCharacter>

    @Query("SELECT * FROM rickandmortycharacter WHERE name LIKE  :searchQuery")
    fun searchCharacters(searchQuery: String): Flow<List<RickAndMortyCharacter>>

}