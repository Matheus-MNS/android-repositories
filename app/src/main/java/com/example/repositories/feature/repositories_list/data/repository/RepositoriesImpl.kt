package com.example.repositories.feature.repositories_list.data.repository

import com.example.repositories.feature.repositories_list.data.remote.data_source.RepositoriesDataSource
import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import com.example.repositories.feature.repositories_list.domain.repository.RepositoriesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class RepositoriesImpl(
    private val remoteDataSource: RepositoriesDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) : RepositoriesRepository {
    override fun getRepositories(user: String): Flow<List<RepositoriesModel>> =
        remoteDataSource.getRepositories(user).flowOn(dispatcher)
}