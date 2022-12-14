package com.example.pureumgittest

import com.example.domain.DomainUser
import com.example.domain.repositry.UserRepository
import javax.inject.Inject

/**
 * 2022-12-14
 * pureum
 */
class UserUseCase @Inject constructor(
    private val userRepository : UserRepository
){
    suspend fun getUser(token:String) : DomainUser{
        return userRepository.getUser(token)
    }
}