package com.darklabs.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    var title: String? = null,
    var content: String? = null,
    val imageUrl: String? = null
) : Parcelable