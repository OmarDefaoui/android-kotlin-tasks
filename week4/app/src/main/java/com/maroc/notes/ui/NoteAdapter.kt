package com.maroc.notes.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maroc.notes.databinding.ItemNoteBinding
import com.maroc.notes.model.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(var notes: List<Note>, private val viewModel: NotesViewModel) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = notes[position].title
            tvBody.text = notes[position].body
            tvDate.text =
                SimpleDateFormat("EEE, d MMM yyyy HH:mm")
                    .parse(notes[position].date).toString()

            ivEdit.setOnClickListener {
                showDialogUpdateNote(it.context, notes[position])
            }
            ivDelete.setOnClickListener {
                viewModel.delete(notes[position])
            }
        }
    }

    fun showDialogUpdateNote(context: Context, note: Note) {
        AddNoteDialog(context, object : AddDialogListener {
            override fun onAddButtonClicked(item: Note) {
                item.id = note.id
                viewModel.update(item)
            }
        }, note).show()
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}