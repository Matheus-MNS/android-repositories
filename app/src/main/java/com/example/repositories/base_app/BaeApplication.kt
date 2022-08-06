package com.example.repositories.base_app

import android.app.Application
import com.example.repositories.common.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    commonModule
                )

            ).androidContext(applicationContext)

        }
    }
}