package com.example.repositories.feature.repositories_list.presentation

import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel

sealed class RepositoriesViewState {
    object Loading : RepositoriesViewState()
    data class Success(val repositoriesList: List<RepositoriesModel>) : RepositoriesViewState()
    data class Error(val messageError:String) : RepositoriesViewState()
}
