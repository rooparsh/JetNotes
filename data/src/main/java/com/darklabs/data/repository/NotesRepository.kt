package com.darklabs.data.repository

import com.darklabs.data.remote.model.Note

interface NotesRepository {
    suspend fun getNotes(): List<Note>
}