package com.example.pureumgittest

import com.example.domain.DomainAccessToken
import com.example.domain.repositry.TokenRepository
import javax.inject.Inject

class TokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend fun getToken(clientId: String, clientSecret: String, code:String): DomainAccessToken
    {
        return tokenRepository.getToken(clientId,clientSecret,code)
    }
}