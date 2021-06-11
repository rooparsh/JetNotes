package com.darklabs.data.di.module

import com.darklabs.data.remote.api.JokeApiService
import com.darklabs.data.remote.source.joke.RemoteJokeSource
import com.darklabs.data.remote.source.joke.RemoteJokeSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {

    @Provides
    @Singleton
    fun provideJokeRemoteSource(jokeApiService: JokeApiService): RemoteJokeSource =
        RemoteJokeSourceImpl(jokeApiService)
}