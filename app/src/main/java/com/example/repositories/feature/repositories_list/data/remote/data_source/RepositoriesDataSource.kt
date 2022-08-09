package com.example.repositories.feature.repositories_list.data.remote.data_source

import com.example.repositories.feature.repositories_list.data.remote.model.OwnerResponse
import com.example.repositories.feature.repositories_list.data.remote.model.RepositoriesResponse
import com.example.repositories.feature.repositories_list.data.remote.service.RepositoriesService
import com.example.repositories.feature.repositories_list.domain.model.OwnerModel
import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoriesDataSource(private val service: RepositoriesService) {

    fun getRepositories(user: String): Flow<List<RepositoriesModel>> = flow {
        emit(service.getRepositories(user).toDomain())
    }

    private fun List<RepositoriesResponse>.toDomain(): List<RepositoriesModel> =
        this.map {
            RepositoriesModel(
                id = it.id ?: 0,
                name = it.name.orEmpty(),
                owner = it.owner?.toDomain() ?: OwnerModel(),
                stargazersCount = it.stargazersCount ?: 0,
                language = it.language.orEmpty(),
                htmlURL = it.htmlURL.orEmpty(),
                description = it.description.orEmpty()
            )
        }

    private fun OwnerResponse.toDomain() = OwnerModel(
        login = login.orEmpty(),
        avatarURL = avatarURL.orEmpty()
    )
}