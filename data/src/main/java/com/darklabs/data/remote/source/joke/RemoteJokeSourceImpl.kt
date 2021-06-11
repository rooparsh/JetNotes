package com.darklabs.data.remote.source.joke

import com.darklabs.data.remote.SafeResult
import com.darklabs.data.remote.api.JokeApiService
import com.darklabs.data.remote.model.JokeResponse
import com.darklabs.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class RemoteJokeSourceImpl @Inject constructor(
    private val jokeApiService: JokeApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteJokeSource {

    override suspend fun getRandomJokes(): SafeResult<JokeResponse> = safeApiCall(dispatcher) {
        jokeApiService.getRandomJokes()
    }

}