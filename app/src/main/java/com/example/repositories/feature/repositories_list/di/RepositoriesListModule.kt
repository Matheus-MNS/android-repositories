package com.example.repositories.feature.repositories_list.di

import com.example.repositories.feature.repositories_list.data.remote.data_source.RepositoriesDataSource
import com.example.repositories.feature.repositories_list.data.remote.service.RepositoriesService
import com.example.repositories.feature.repositories_list.data.repository.RepositoriesImpl
import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import com.example.repositories.feature.repositories_list.domain.repository.RepositoriesRepository
import com.example.repositories.feature.repositories_list.domain.use_case.RepositoriesUseCase
import com.example.repositories.feature.repositories_list.presentation.RepositoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoriesListModule = module {
    viewModel {
        RepositoriesViewModel(
            repositoriesUseCase = RepositoriesUseCase(
                repository = RepositoriesImpl(
                    remoteDataSource = RepositoriesDataSource(
                        service = get<Retrofit>().create(RepositoriesService::class.java)
                    )
                )
            )
        )
    }
}