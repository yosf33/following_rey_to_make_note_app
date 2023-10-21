package com.example.reynoteapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reynoteapp.databinding.NoteBinding
import com.example.reynoteapp.db.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    private lateinit var binding: NoteBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = NoteBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Note) {
            //InitView
            binding.apply {
                //Set text
                tvTitle.text = item.noteTitle
                tvDesc.text= item.noteDesc
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}
