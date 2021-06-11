package com.darklabs.domain.mapper

import com.darklabs.data.remote.model.JokeResponse
import com.darklabs.domain.model.Joke

fun JokeResponse.toJokes(): List<Joke> {
    return this.value.map { jokeResponse ->
        Joke(
            jokeResponse.id,
            jokeResponse.joke
        )
    }
}