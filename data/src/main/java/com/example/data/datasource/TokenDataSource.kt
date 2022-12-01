package com.example.data.datasource

import com.example.data.AccessToken
import com.example.data.BuildConfig
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * 2022-12-01
 * pureum
 */

interface TokenDataSource {
    @Headers("Accept: application/json")
    @POST(BuildConfig.domainURL + "login/oauth/access_token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ): AccessToken
}