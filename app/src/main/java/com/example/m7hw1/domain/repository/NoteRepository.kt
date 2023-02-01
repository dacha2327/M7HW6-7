package com.example.m7hw1.domain.repository

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.utils.Resource
import java.util.concurrent.Flow

interface NoteRepository {

    fun createNote(note: Note) : kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun editNote(note: Note) : kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun deleteNote(note: Note) : kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun getNote(): kotlinx.coroutines.flow.Flow<Resource<List<Note>>>
}