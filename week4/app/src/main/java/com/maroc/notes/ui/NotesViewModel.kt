package com.maroc.notes.ui

import androidx.lifecycle.ViewModel
import com.maroc.notes.model.Note
import com.maroc.notes.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NoteRepository) : ViewModel() {
    fun upsert(item: Note) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: Note) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun update(item: Note) = CoroutineScope(Dispatchers.IO).launch {
        repository.update(item)
    }

    fun getAllNotes() = repository.getAllNotes()
}