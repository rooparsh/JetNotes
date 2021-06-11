package com.darklabs.domain.mapper

import com.darklabs.data.remote.model.Note
import com.darklabs.domain.model.Note as UiNote

fun List<Note>.toNote(): List<UiNote> {
    return this.map { UiNote(title = it.title, content = it.content, imageUrl = it.imageUrl) }
}