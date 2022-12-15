package com.kguard.data.module

import com.example.data.datasource.RepoDataSource
import com.example.data.datasource.TokenDataSource
import com.example.data.datasource.UserDataSource
import com.example.data.repoImpl.RepoRepositoryImpl
import com.example.data.repoImpl.TokenRepositoryImpl
import com.example.data.repoImpl.UserRepositoryImpl
import com.example.domain.repositry.RepoRepository
import com.example.domain.repositry.TokenRepository
import com.example.domain.repositry.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepoRepository(RepoDataSource: RepoDataSource): RepoRepository {
        return RepoRepositoryImpl(RepoDataSource)
    }
    @Provides
    @Singleton
    fun provideUserRepository(UserDataSource: UserDataSource): UserRepository { //유저레포로 반환되넹
        return UserRepositoryImpl(UserDataSource)
    }
    @Provides
    @Singleton
    fun provideTokenRepository(GitDataSource: TokenDataSource): TokenRepository {
        return TokenRepositoryImpl(GitDataSource)
    }
}