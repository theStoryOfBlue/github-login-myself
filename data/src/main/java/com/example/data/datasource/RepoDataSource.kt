package com.example.data.datasource

import com.example.data.Repo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

/**
 * 2022-12-15
 * pureum
 */
interface RepoDataSource {
    @Headers("Accept: application/json")
    @GET("user/repos")
    suspend fun getRepositories(
        @Header("authorization") token:String
    ): List<Repo>
}