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

    @Query("SELECT * FROM characters")
    fun getCharacters(): Flow<List<RickAndMortyCharacter>>

}