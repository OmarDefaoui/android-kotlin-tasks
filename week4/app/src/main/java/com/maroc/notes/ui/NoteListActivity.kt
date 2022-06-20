package com.maroc.notes.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.widget.AbsListView
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.maroc.notes.R
import com.maroc.notes.databinding.ActivityNoteListBinding
import com.maroc.notes.db.NotesDB
import com.maroc.notes.model.Note
import com.maroc.notes.repository.NoteRepository
import java.util.*


class NoteListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = NotesDB(this)
        val repository = NoteRepository(database)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(
            this,
            factory
        ).get(NotesViewModel::class.java)

        val adapter = NoteAdapter(listOf(), viewModel)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        viewModel.getAllNotes().observe(this, androidx.lifecycle.Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddNoteDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: Note) {
                    viewModel.upsert(item)
                }
            }, null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}