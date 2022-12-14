package com.example.data

import com.example.domain.DomainUser

/**
 * 2022-12-14
 * pureum
 */
data class User(
    val username: String,
    val name: String,
    val email: String,
    val bio: String,
    val location: String,
    val followers: Int,
    val following: Int,
)

fun User.toDomainUser() : DomainUser = DomainUser(
    username, name, email, bio, location, followers, following
)