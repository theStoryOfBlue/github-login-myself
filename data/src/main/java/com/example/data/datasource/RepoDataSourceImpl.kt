package com.example.data.datasource

import com.example.data.Repo
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

/**
 * 2022-12-15
 * pureum
 */
class RepoDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): RepoDataSource{
    override suspend fun getRepositories(token: String): List<Repo> {
        return retrofit.create(RepoDataSource::class.java).getRepositories(token)
    }
}