package com.timplifier.rickandmorty.di

import android.content.Context
import com.timplifier.rickandmorty.data.local.db.RoomClient
import com.timplifier.rickandmorty.data.local.db.database.AppDatabase
import org.koin.dsl.module

val roomModule = module {

    val roomClient = RoomClient()
    fun provideRoomDatabase(context: Context) {
        roomClient.provideRoomDatabase(context)

    }

    fun provideCharacterDao(appDatabase: AppDatabase) =

        roomClient.provideCharacterDao(appDatabase)

    fun provideLocationDao(appDatabase: AppDatabase) =
        roomClient.provideLocationDao(appDatabase)

    fun provideEpisodeDao(appDatabase: AppDatabase) =
        roomClient.provideEpisodeDao(appDatabase)

    single { provideRoomDatabase(get()) }
    single { provideCharacterDao(get()) }
    single { provideLocationDao(get()) }
    single { provideEpisodeDao(get()) }
}