package com.timplifier.rickandmorty.di

import com.timplifier.rickandmorty.data.remote.RetrofitClient
import org.koin.dsl.module


val networkModule = module {

    single { RetrofitClient().provideCharactersApiService() }
    single { RetrofitClient().provideLocationApiService() }
    single { RetrofitClient().provideEpisodesApiService() }
}