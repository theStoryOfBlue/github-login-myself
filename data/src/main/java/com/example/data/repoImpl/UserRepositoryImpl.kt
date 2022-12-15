package com.example.data.repoImpl

import com.example.data.datasource.UserDataSource
import com.example.data.toDomainUser
import com.example.domain.DomainUser
import com.example.domain.repositry.UserRepository
import javax.inject.Inject

/**
 * 2022-12-14
 * pureum
 */
class UserRepositoryImpl @Inject constructor(private val api: UserDataSource): UserRepository {
    override suspend fun getUser(token :String): DomainUser {
        return api.getUserData(token).toDomainUser()
    }
}