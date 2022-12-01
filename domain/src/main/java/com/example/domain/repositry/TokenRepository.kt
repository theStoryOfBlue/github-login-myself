package com.example.domain.repositry

import com.example.domain.DomainAccessToken

interface TokenRepository {
    suspend fun getToken(clientId: String, clientSecret: String, code:String): DomainAccessToken
}