package com.timplifier.rickandmorty.servicelocator

import com.timplifier.rickandmorty.data.remote.RetrofitClient
import org.koin.dsl.module


val networkModule = module {

    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharactersApiService() }
    single { get<RetrofitClient>().provideLocationApiService() }
    single { get<RetrofitClient>().provideEpisodesApiService() }
}
