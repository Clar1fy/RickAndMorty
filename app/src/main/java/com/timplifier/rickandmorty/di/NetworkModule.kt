package com.timplifier.rickandmorty.di

import com.timplifier.rickandmorty.data.remote.RetrofitClient
import org.koin.dsl.module


private val networkModule = module {

    single { RetrofitClient() }

}