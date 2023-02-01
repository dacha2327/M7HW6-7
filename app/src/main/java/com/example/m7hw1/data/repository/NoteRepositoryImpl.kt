package com.example.m7hw1.data.repository

import com.example.m7hw1.data.local.NoteDao
import com.example.m7hw1.data.mappers.toNote
import com.example.m7hw1.data.mappers.toNoteEntity
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository
import com.example.m7hw1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override fun createNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        kotlinx.coroutines.delay(1000)
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (ioException :IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note): Flow<Resource<Unit>> = flow {
        try {
            val data = noteDao.editNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (ioException :IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
        try {
            val data = noteDao.deleteNote(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (ioException :IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getNote(): Flow<Resource<List<Note>>> = flow {
        try {
            val data = noteDao.getNote().map { it.toNote() }
            emit(Resource.Success(data))
        } catch (ioException :IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)


}