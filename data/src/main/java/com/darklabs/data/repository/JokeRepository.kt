package com.darklabs.data.repository

import com.darklabs.data.remote.SafeResult
import com.darklabs.data.remote.model.JokeResponse

interface JokeRepository {
    suspend fun getRandomJokes(): SafeResult<JokeResponse>
}