package com.example.data.datasource

import com.example.data.User
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 2022-12-14
 * pureum
 */
class UserDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): UserDataSource{
    override suspend fun getUserData(token: String): User {
        return retrofit.create(UserDataSource::class.java).getUserData(token)
    }
}