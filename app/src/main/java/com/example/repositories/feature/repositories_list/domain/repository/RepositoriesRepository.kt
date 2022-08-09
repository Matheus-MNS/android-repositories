package com.example.repositories.feature.repositories_list.domain.repository

import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import kotlinx.coroutines.flow.Flow

interface RepositoriesRepository {

    fun getRepositories(user: String): Flow<List<RepositoriesModel>>
}