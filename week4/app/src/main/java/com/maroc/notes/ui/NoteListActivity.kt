package com.maroc.notes.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.widget.AbsListView
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.maroc.notes.R
import com.maroc.notes.databinding.ActivityNoteListBinding
import com.maroc.notes.model.Note
import com.maroc.notes.utils.NoteAdapter
import java.util.*


class NoteListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteListSingleItem =
            mutableListOf(Note("title 1", "this is the first content", Calendar.getInstance().time))

        val adapter = NoteAdapter(noteListSingleItem)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("New Note")

            // Set up the input title
            val inputTitle = EditText(this)
            inputTitle.hint = "Enter note title"

            // Set up the input body
            val inputBody = EditText(this)
            inputBody.hint = "Enter note body"

            // Set up linear layout
            val parent = LinearLayout(this)
            parent.layoutParams =
                LinearLayout.LayoutParams(
                    AbsListView.LayoutParams.MATCH_PARENT,
                    AbsListView.LayoutParams.WRAP_CONTENT
                )
            parent.orientation = LinearLayout.VERTICAL
            parent.addView(inputTitle)
            parent.addView(inputBody)
            builder.setView(parent)

            // Set up the buttons
            builder.setPositiveButton("Add", DialogInterface.OnClickListener { dialog, which ->
                val title = inputTitle.text.toString()
                val body = inputBody.text.toString()
                val newTodo = Note(title, body, Calendar.getInstance().time)
                noteListSingleItem.add(newTodo)
                adapter.notifyDataSetChanged()
            })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

            builder.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}