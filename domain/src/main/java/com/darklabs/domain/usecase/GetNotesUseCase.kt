package com.darklabs.domain.usecase

import com.darklabs.data.repository.NotesRepository
import com.darklabs.domain.mapper.toNote
import com.darklabs.domain.model.Note
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) : BaseUseCase<Unit, List<Note>> {

    override suspend fun perform(): List<Note> {
        return notesRepository.getNotes().toNote()
    }

}