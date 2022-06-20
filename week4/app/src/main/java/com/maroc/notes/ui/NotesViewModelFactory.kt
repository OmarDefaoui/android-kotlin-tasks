package com.maroc.notes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maroc.notes.repository.NoteRepository

class NotesViewModelFactory(private val repository: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(repository) as T
    }
}