package com.example.domain.repositry

import com.example.domain.DomainRepo

/**
 * 2022-12-15
 * pureum
 */
interface RepoRepository {
    suspend fun getRepo(token:String):List<DomainRepo>
}