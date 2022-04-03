package com.timplifier.rickandmorty.di

import android.content.Context
import com.timplifier.rickandmorty.data.local.db.RoomClient
import com.timplifier.rickandmorty.data.local.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


    @Singleton
    private val roomClient = RoomClient()

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        roomClient.provideRoomDatabase(context)

    @Singleton
    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase) =
        roomClient.provideCharacterDao(appDatabase)

    @Singleton
    @Provides
    fun provideLocationDao(appDatabase: AppDatabase) = roomClient.provideLocationDao(appDatabase)

    @Singleton
    @Provides
    fun provideEpisodeDao(appDatabase: AppDatabase) = roomClient.provideEpisodeDao(appDatabase)


}