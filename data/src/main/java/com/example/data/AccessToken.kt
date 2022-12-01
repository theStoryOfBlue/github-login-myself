package com.example.data

import com.example.domain.DomainAccessToken
import com.google.gson.annotations.SerializedName

/**
 * 2022-12-01
 * pureum
 */
data class AccessToken(
    @SerializedName("access_token")
    val accessToken: String,
)

fun AccessToken.toDomainAccessToken() : DomainAccessToken = DomainAccessToken(
    accessToken=accessToken
)