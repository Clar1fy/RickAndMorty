package com.timplifier.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(vararg locations: RickAndMortyLocation)

    @Query("SELECT * FROM rickandmortylocation")
    fun getLocations(id: Int): Flow<RickAndMortyLocation>
}