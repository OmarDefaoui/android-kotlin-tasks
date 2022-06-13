package com.maroc.notes.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maroc.notes.databinding.ItemNoteBinding
import com.maroc.notes.model.Note
import java.text.SimpleDateFormat

class NoteAdapter(var notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

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
                    .format(notes[position].date).toString()

            ivEdit.setOnClickListener {

            }
            ivDelete.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}