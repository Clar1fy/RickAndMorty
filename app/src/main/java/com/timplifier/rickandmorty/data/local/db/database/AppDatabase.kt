package com.timplifier.rickandmorty.data.local.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.timplifier.rickandmorty.data.local.db.converters.CharacterConverter
import com.timplifier.rickandmorty.data.local.db.converters.EpisodeConverter
import com.timplifier.rickandmorty.data.local.db.converters.LocationConverter
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
@TypeConverters(CharacterConverter::class, LocationConverter::class, EpisodeConverter::class)


abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
}