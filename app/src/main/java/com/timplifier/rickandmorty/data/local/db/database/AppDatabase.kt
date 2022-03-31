package com.timplifier.rickandmorty.data.local.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timplifier.rickandmorty.data.local.db.daos.CharacterDao
import com.timplifier.rickandmorty.data.local.db.daos.EpisodeDao
import com.timplifier.rickandmorty.data.local.db.daos.LocationDao
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

@Database(
    entities = [RickAndMortyCharacter::class, RickAndMortyLocation::class, RickAndMortyEpisode::class],
    version = 1
)


abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
}