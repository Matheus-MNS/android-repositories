package com.example.repositories.feature.repositories_list.data.remote.model

import com.google.gson.annotations.SerializedName

data class RepositoriesResponse(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("owner")
    val owner: OwnerResponse? = null,
    @SerializedName("stargazers_count")
    val stargazersCount: Long?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("html_url")
    val htmlURL: String?,
    @SerializedName("description")
    val description: String?

)