package com.example.data.datasource

import com.example.data.AccessToken
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 2022-12-01
 * pureum
 */
class TokenDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
) :TokenDataSource {
    override suspend fun getAccessToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): AccessToken {
        val pu =retrofit.create(TokenDataSource::class.java).getAccessToken(clientId,clientSecret,code)
        return pu
    }

}