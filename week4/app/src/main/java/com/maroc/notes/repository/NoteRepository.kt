package com.maroc.notes.repository

import androidx.lifecycle.LiveData
import com.maroc.notes.db.NotesDB
import com.maroc.notes.model.Note

class NoteRepository(private val db: NotesDB) {
    suspend fun upsert(item: Note) = db.getNotesDao().upsert(item)

    suspend fun delete(item: Note) = db.getNotesDao().delete(item)

    suspend fun update(item: Note) = db.getNotesDao().update(item)

    fun getAllNotes() = db.getNotesDao().getAllNotes()
}