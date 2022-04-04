package com.timplifier.rickandmorty.servicelocator

import com.timplifier.rickandmorty.data.local.db.RoomClient
import org.koin.dsl.module

val roomModule = module {

    val roomClient = RoomClient()

    single { roomClient.provideRoomDatabase(get()) }
    single { roomClient.provideCharacterDao(get()) }
    single { roomClient.provideLocationDao(get()) }
    single { roomClient.provideEpisodeDao(get()) }
}