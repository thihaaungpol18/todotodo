package com.thiha.roomexe.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.thiha.roomexe.R
import com.thiha.roomexe.db.Note
import com.thiha.roomexe.viewmodel.NoteViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.id_recyclerview)
        fab = findViewById(R.id.id_fab)
        adapter = NoteAdapter(this@MainActivity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        noteViewModel = ViewModelProviders.of(this@MainActivity).get(NoteViewModel::class.java)

        noteViewModel.allNotes.observe(this@MainActivity, Observer {
            adapter.setNotes(it)
        })


        fab.setOnClickListener {
            startActivityForResult(
                Intent(this@MainActivity, AddEditNoteActivity::class.java),
                ADD_NOTE_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_NOTE_CODE && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra(AddEditNoteActivity.INTENT_TITLE)
            val description = data?.getStringExtra(AddEditNoteActivity.INTENT_DESCRIPTION)
            noteViewModel.insert(Note(0, title!!, description!!, Date().toString()))
        } else {
            Snackbar.make(recyclerView, "Note Not Saved", Snackbar.LENGTH_LONG).show()
        }
    }

    companion object {
        const val ADD_NOTE_CODE = 1
    }
}