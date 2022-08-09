package com.example.repositories.feature.repositories_list.domain.use_case

import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import com.example.repositories.feature.repositories_list.domain.repository.RepositoriesRepository
import kotlinx.coroutines.flow.Flow

class RepositoriesUseCase(private val repository: RepositoriesRepository) {
    operator fun invoke(user: String): Flow<List<RepositoriesModel>> =
        repository.getRepositories(user)
}