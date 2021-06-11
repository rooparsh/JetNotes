package com.darklabs.domain.di.module

import com.darklabs.data.repository.JokeRepository
import com.darklabs.domain.usecase.GetRandomJokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetRandomJokeUseCase(jokeRepository: JokeRepository): GetRandomJokeUseCase =
        GetRandomJokeUseCase(jokeRepository)
}