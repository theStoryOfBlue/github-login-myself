package com.kguard.data.module

import com.example.data.datasource.TokenDataSource
import com.example.data.datasource.TokenDataSourceImpl
//import com.kguard.data.datasource.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideTokenDataSource(retrofit: Retrofit): TokenDataSource {
        return TokenDataSourceImpl(retrofit)
    }
//    @Provides
//    @Singleton
//    fun provideUserDataSource(retrofit: Retrofit): UserDataSource {
//        return UserDataSourceImpl(retrofit)
//    }
//    @Provides
//    @Singleton
//    fun provideRepoDataSource(retrofit: Retrofit): RepoDataSource {
//        return RepoDataSourceImpl(retrofit)
//    }
}