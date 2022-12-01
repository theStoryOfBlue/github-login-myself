package com.kguard.data.module

import com.example.data.datasource.TokenDataSource
import com.example.data.repoImpl.TokenRepositoryImpl
import com.example.domain.repositry.TokenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
//    @Provides
//    @Singleton
//    fun provideRepoRepository(RepoDataSource: RepoDataSource): RepoRepository {
//        return RepoRepositoryImpl(RepoDataSource)
//    }
//    @Provides
//    @Singleton
//    fun provideUserRepository(UserDataSource: UserDataSource): UserRepository {
//        return UserRepositoryImpl(UserDataSource)
//    }
    @Provides
    @Singleton
    fun provideTokenRepository(GitDataSource: TokenDataSource): TokenRepository {
        return TokenRepositoryImpl(GitDataSource)
    }
}