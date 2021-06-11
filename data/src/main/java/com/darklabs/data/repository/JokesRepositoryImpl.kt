package com.darklabs.data.repository

import com.darklabs.data.remote.SafeResult
import com.darklabs.data.remote.model.JokeResponse
import com.darklabs.data.remote.source.joke.RemoteJokeSource
import javax.inject.Inject

internal class JokesRepositoryImpl @Inject constructor(private val remoteJokeSource: RemoteJokeSource) :
    JokeRepository {

    override suspend fun getRandomJokes(): SafeResult<JokeResponse> {
        return remoteJokeSource.getRandomJokes()
    }
}