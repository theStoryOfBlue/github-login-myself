package com.example.domain

data class DomainUser(
    val username: String?,
    val name: String,
    val email: String?,
    val bio: String?,
    val location: String?,
    val followers: Int?,
    val following: Int?,
)
