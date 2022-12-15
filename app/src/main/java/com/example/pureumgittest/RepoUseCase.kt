package com.example.pureumgittest

import com.example.data.Repo
import com.example.domain.DomainRepo
import com.example.domain.repositry.RepoRepository
import com.example.domain.repositry.UserRepository
import javax.inject.Inject

/**
 * 2022-12-15
 * pureum
 */
class RepoUseCase @Inject constructor(private val repoRepository: RepoRepository){
    suspend fun getRepo(token:String): List<DomainRepo>{
        return repoRepository.getRepo(token)
    }
}