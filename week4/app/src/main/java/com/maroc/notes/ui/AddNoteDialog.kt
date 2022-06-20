package com.maroc.notes.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.maroc.notes.databinding.DialogAddNoteBinding
import com.maroc.notes.model.Note
import java.text.SimpleDateFormat
import java.util.*

class AddNoteDialog(context: Context, var addDialogListener: AddDialogListener, val note: Note?) :
    AppCompatDialog(context) {

    private lateinit var binding: DialogAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (note != null) {
            binding.tvHeader.text = "Edit Note"
            binding.etTitle.setText(note.title)
            binding.etTitle.setSelection(binding.etTitle.text.length)
            binding.etBody.setText(note.body)
            binding.etBody.setSelection(binding.etBody.text.length)
            binding.btnAdd.text = "Edit"
        }

        binding.btnAdd.setOnClickListener {
            var title = binding.etTitle.text.toString()
            var body = binding.etBody.text.toString()

            if (title.isEmpty() || body.isEmpty()) {
                Toast.makeText(context, "Note's title and body cannot be null", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val newNote = Note(
                title, body, SimpleDateFormat("EEE, d MMM yyyy HH:mm")
                    .format(Calendar.getInstance().time).toString()
            )
            addDialogListener.onAddButtonClicked(newNote)
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }
}