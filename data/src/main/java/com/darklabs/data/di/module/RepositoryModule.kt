package com.darklabs.data.di.module

import com.darklabs.data.remote.api.JokeApiService
import com.darklabs.data.remote.source.joke.RemoteJokeSource
import com.darklabs.data.remote.source.joke.RemoteJokeSourceImpl
import com.darklabs.data.repository.JokeRepository
import com.darklabs.data.repository.JokesRepositoryImpl
import com.darklabs.data.repository.NotesRepository
import com.darklabs.data.repository.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindJokeRepository(remoteJokeSource: RemoteJokeSource): JokeRepository

}*/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideJokeRepository(remoteJokeSource: RemoteJokeSource): JokeRepository =
        JokesRepositoryImpl(remoteJokeSource)

    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository = NotesRepositoryImpl()
}