package com.darklabs.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class JokeResponse(
    @SerialName("type")
    val type: String,
    @SerialName("value")
    val value: List<Joke>
)

@Serializable
data class Joke(
    @SerialName("id") val id: Int,
    @SerialName("joke") val joke: String
)
