package com.example.data.datasource

import com.example.data.BuildConfig
import com.example.data.User
import retrofit2.http.*

/**
 * 2022-12-14
 * pureum
 */
interface UserDataSource {
    @Headers("Accept: application/json")
    @GET("user")
    suspend fun getUserData(
        @Header("authorization") token: String
    ): User
}