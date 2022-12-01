package com.example.pureumgittest

import com.example.domain.repositry.TokenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
/*    @Provides
    @Singleton
    fun provideRepoUseCase(repository: RepoRepository):RepoUseCase{
        return RepoUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideUserUseCase(repository: UserRepository):UserUseCase{
        return UserUseCase(repository)
    }*/
    @Provides
    @Singleton
    fun provideTokenUseCase(repository: TokenRepository):TokenUseCase{
        return TokenUseCase(repository)
    }
}