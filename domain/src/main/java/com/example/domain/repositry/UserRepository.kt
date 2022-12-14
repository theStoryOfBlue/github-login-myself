package com.example.domain.repositry

import com.example.domain.DomainUser

/**
 * 2022-12-14
 * pureum
 */
interface UserRepository{
    suspend fun getUser(token:String): DomainUser
}