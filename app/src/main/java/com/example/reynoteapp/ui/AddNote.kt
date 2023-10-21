package com.example.reynoteapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.reynoteapp.R
import com.example.reynoteapp.databinding.FragmentAddNoteBinding
import com.example.reynoteapp.db.Note
import com.example.reynoteapp.db.NoteDatabase
import com.google.android.material.snackbar.Snackbar

class AddNote : Fragment() {
    lateinit var binding: FragmentAddNoteBinding//why can't add addnotebinding
    private val noteDB: NoteDatabase by lazy {
        Room.databaseBuilder(
            requireContext().applicationContext,
            NoteDatabase::class.java,
            "NOTE_DATABASE"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private lateinit var noteEntity: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAddNoteBinding.inflate(layoutInflater)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() || desc.isNotEmpty()) {
                    noteEntity = Note(0, title, desc)
                    noteDB.doa().inserNote(noteEntity)
                    getActivity()?.finish()
                    Snackbar.make(it, "saved", Snackbar.LENGTH_LONG).show()
                } else {
                    Snackbar.make(it, "Title and Description cannot be Empty", Snackbar.LENGTH_LONG)
                        .show()
                }
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }
}

