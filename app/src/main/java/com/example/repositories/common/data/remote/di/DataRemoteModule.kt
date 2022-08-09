package com.example.repositories.common.data.remote.di

import com.example.repositories.BuildConfig
import com.example.repositories.common.data.remote.WebServiceFactory.provideOkHttpClient
import com.example.repositories.common.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        provideRetrofit(
            provideOkHttpClient(
                BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "debug"
            )
        )
    }
}