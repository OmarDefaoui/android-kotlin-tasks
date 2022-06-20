package com.maroc.notes.ui

import com.maroc.notes.model.Note

interface AddDialogListener {
    fun onAddButtonClicked(item: Note)
}