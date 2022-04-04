package com.timplifier.rickandmorty.data.local.db

import android.content.Context
import androidx.room.Room
import com.timplifier.rickandmorty.data.local.db.daos.CharacterDao
import com.timplifier.rickandmorty.data.local.db.daos.EpisodeDao
import com.timplifier.rickandmorty.data.local.db.daos.LocationDao
import com.timplifier.rickandmorty.data.local.db.database.AppDatabase

class RoomClient {

    fun provideRoomDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "database")

            .allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()


    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao =
        appDatabase.characterDao()

    fun provideLocationDao(appDatabase: AppDatabase): LocationDao =
        appDatabase.locationDao()

    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodeDao =
        appDatabase.episodeDao()
}