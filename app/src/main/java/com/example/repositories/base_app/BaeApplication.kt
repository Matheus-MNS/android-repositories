package com.example.repositories.base_app

import android.app.Application
import com.example.repositories.common.data.remote.di.dataRemoteModule
import com.example.repositories.feature.repositories_list.di.repositoriesListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    dataRemoteModule,
                    repositoriesListModule
                )

            ).androidContext(applicationContext)

        }
    }
}