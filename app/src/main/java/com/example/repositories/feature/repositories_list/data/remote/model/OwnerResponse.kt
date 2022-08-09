package com.example.repositories.feature.repositories_list.data.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatarURL: String? = null
)
