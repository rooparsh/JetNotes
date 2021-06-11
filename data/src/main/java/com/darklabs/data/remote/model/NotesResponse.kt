package com.darklabs.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    @SerialName("title") var title: String? = null,
    @SerialName("content") var content: String? = null,
    @SerialName("imageUrl") val imageUrl: String? = null
)
