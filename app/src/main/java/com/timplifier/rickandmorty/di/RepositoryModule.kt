package com.timplifier.rickandmorty.di

import com.timplifier.rickandmorty.data.repositories.CharacterRepository
import com.timplifier.rickandmorty.data.repositories.EpisodesRepository
import com.timplifier.rickandmorty.data.repositories.LocationsRepository
import org.koin.dsl.module


val repositoryModule = module {

    factory { CharacterRepository(get(), get()) }
    factory { LocationsRepository(get(), get()) }
    factory { EpisodesRepository(get(), get()) }

}