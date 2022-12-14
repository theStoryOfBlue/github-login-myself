package com.example.data.repoImpl

import android.util.Log
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
    override suspend fun getToken(clientId: String, clientSecret: String, code: String): DomainAccessToken {
        val pu2 = api.getAccessToken(clientId,clientSecret,code).toDomainAccessToken()
        Log.e("TAG", "TokenRepositoryImpl getToken pu2 : $pu2", )
        return pu2
    }
}