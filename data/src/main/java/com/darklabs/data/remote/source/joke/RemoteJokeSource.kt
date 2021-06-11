package com.darklabs.data.remote.source.joke

import com.darklabs.data.remote.SafeResult
import com.darklabs.data.remote.model.JokeResponse

interface RemoteJokeSource {
    suspend fun getRandomJokes(): SafeResult<JokeResponse>
}