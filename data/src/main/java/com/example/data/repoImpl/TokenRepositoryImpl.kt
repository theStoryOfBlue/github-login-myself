package com.example.data.repoImpl

import com.example.data.datasource.TokenDataSource
import com.example.data.toDomainAccessToken
import com.example.domain.DomainAccessToken
import com.example.domain.repositry.TokenRepository
import javax.inject.Inject

/**
 * 2022-12-01
 * pureum
 */
class TokenRepositoryImpl @Inject constructor(private val api: TokenDataSource): TokenRepository {
    override suspend fun getToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): DomainAccessToken {
        return api.getAccessToken(clientId,clientSecret,code).toDomainAccessToken()
    }
}