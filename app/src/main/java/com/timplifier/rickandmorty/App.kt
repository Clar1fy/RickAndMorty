package com.timplifier.rickandmorty

import android.app.Application
import com.timplifier.rickandmorty.servicelocator.networkModule
import com.timplifier.rickandmorty.servicelocator.repositoryModule
import com.timplifier.rickandmorty.servicelocator.roomModule
import com.timplifier.rickandmorty.servicelocator.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(networkModule, repositoryModule, viewModelModule, roomModule)
        }
    }
}
