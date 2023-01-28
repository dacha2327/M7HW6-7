package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository

class CreateNotesUseCase(private val noteRepository: NoteRepository) {
    
    fun createNotes(note: Note) = noteRepository.createNote(note)
}