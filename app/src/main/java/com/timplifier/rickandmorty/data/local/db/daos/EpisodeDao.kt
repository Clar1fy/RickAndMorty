package com.timplifier.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisodes(vararg episode: RickAndMortyEpisode)

    @Query("SELECT * FROM rickandmortyepisode")
    fun getEpisodes(): List<RickAndMortyEpisode>
}