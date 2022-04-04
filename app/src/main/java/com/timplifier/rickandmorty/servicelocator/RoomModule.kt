package com.timplifier.rickandmorty.servicelocator

import com.timplifier.rickandmorty.data.local.db.RoomClient
import org.koin.dsl.module

val roomModule = module {


    single { RoomClient() }
    single { get<RoomClient>().provideRoomDatabase(get()) }
    single { get<RoomClient>().provideCharacterDao(get()) }
    single { get<RoomClient>().provideLocationDao(get()) }
    single { get<RoomClient>().provideEpisodeDao(get()) }
}