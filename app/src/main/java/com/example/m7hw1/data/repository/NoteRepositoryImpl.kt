package com.example.m7hw1.data.repository

import com.example.m7hw1.data.local.NoteDao
import com.example.m7hw1.data.mappers.toNote
import com.example.m7hw1.data.mappers.toNoteEntity
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNote(): List<Note> {
        return  noteDao.getNote().map { it.toNote() }
    }

}