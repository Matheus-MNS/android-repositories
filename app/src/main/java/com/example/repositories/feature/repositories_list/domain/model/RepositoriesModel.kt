package com.example.repositories.feature.repositories_list.domain.model


data class RepositoriesModel(
    val id: Long,
    val name: String,
    val owner: OwnerModel = OwnerModel(),
    val stargazersCount: Long,
    val language: String,
    val htmlURL: String,
    val description: String
)