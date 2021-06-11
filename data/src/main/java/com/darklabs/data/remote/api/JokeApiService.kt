package com.darklabs.data.remote.api

import com.darklabs.data.remote.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeApiService {
    @GET("/jokes/random")
    suspend fun getRandomJokes(): Response<JokeResponse>
}