package com.maroc.notes.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.maroc.notes.model.Note

// Dao: data access object
@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: Note)

    @Delete
    fun delete(item: Note)

    @Update
    fun update(item: Note)

    @Query("SELECT * FROM notes_items")
    fun getAllNotes(): LiveData<List<Note>>
}