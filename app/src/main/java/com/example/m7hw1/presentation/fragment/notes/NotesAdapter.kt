package com.example.m7hw1.presentation.fragment.notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.m7hw1.databinding.ItemNoteBinding
import com.example.m7hw1.domain.model.Note

class NotesAdapter : androidx.recyclerview.widget.ListAdapter<Note , NotesAdapter.NoteViewHolder>(
    NoteDiffUtil()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context) , parent , false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NoteViewHolder(private var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Note) {
            binding.textTitle.text = item.title
            binding.textDesc.text = item.desc
        }
    }

    private class NoteDiffUtil : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }
}