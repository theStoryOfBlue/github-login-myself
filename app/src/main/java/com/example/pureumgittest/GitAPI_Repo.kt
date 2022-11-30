package com.example.pureumgittest

import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * 2022-11-30
 * pureum
 */
interface GitAPI_Repo {

    @Headers("Accept: application/json")
    @POST(BuildConfig.domainURL + "login/oauth/access_token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ):AccessToken
}