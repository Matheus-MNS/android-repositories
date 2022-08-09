package com.example.repositories.feature.repositories_list.data.remote.service

import com.example.repositories.feature.repositories_list.data.remote.model.RepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoriesService {
    @GET("users/{user}/repos")
    suspend fun getRepositories(@Path("user") user: String): List<RepositoriesResponse>
}