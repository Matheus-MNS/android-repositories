package com.example.repositories.feature.repositories_list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositories.feature.repositories_list.domain.use_case.RepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

const val ERROR = "Não foi possível encontrar o repositório"

class RepositoriesViewModel(
    private val repositoriesUseCase: RepositoriesUseCase

) : ViewModel() {

    val viewState = MutableLiveData<RepositoriesViewState>()

    fun getRepositories(user: String) {
        viewModelScope.launch {
            repositoriesUseCase(user)
                .onStart {
                    viewState.value = RepositoriesViewState.Loading
                }
                .catch {
                    viewState.value = RepositoriesViewState.Error(ERROR)
                }
                .collect {
                    viewState.value = RepositoriesViewState.Success(it)
                }
        }
    }
}