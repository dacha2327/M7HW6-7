package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository
import javax.inject.Inject

class EditNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    
    fun editNotes(note: Note) = noteRepository.editNote(note)
}