package com.example.data.repoImpl

import com.example.data.datasource.RepoDataSource
import com.example.data.toDomainRepo
import com.example.domain.DomainRepo
import com.example.domain.repositry.RepoRepository
import javax.inject.Inject

/**
 * 2022-12-15
 * pureum
 */
class RepoRepositoryImpl @Inject constructor(private val api: RepoDataSource): RepoRepository {
    override suspend fun getRepo(token:String): List<DomainRepo> {
        return api.getRepositories(token).map{it.toDomainRepo()}
    }
}