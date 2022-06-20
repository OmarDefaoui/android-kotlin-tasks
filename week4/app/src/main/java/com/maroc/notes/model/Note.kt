package com.maroc.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_items")
data class Note(
    @ColumnInfo(name = "note_title") var title: String,
    @ColumnInfo(name = "note_body") var body: String,
    @ColumnInfo(name = "note_date") var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
