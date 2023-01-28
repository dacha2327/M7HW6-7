package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository

class DeleteNotesUseCase(private val noteRepository: NoteRepository) {
    
    fun deleteNotes(note: Note) = noteRepository.deleteNote(note)
}