package com.maroc.notes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maroc.notes.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDB : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    // like const so we will not have repeated values
    companion object {
        @Volatile
        private var instant: NotesDB? = null
        private var LOCK = Any()
        operator fun invoke(context: Context) = instant ?: synchronized(LOCK) {
            instant ?: createDB(context).also {
                instant = it
            }
        }

        private fun createDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NotesDB::class.java,
                "NotesDB.db"
            ).build()
    }
}