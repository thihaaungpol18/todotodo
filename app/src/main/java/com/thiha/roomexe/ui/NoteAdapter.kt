package com.thiha.roomexe.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.thiha.roomexe.R
import com.thiha.roomexe.db.Note

/**
project: RoomExe
Created by : Thiha
date : 6/23/2020
 */
class NoteAdapter(private val context: Context) : RecyclerView.Adapter<NoteAdapter.NoteVH>() {
    private var itemLists: List<Note> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        return NoteVH(
            LayoutInflater.from(
                context
            ).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun getItemCount(): Int = itemLists.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(itemLists[position])
    }

    class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvID: TextView? = null
        private var tvTitle: TextView? = null
        private var tvDescription: TextView? = null

        init {
            tvID = itemView.findViewById(R.id.item_id)
            tvTitle = itemView.findViewById(R.id.item_title)
            tvDescription = itemView.findViewById(R.id.item_desc)
        }

        fun bind(currentNote: Note) {
            tvID?.text = currentNote.id.toString()
            tvTitle?.text = currentNote.title
            tvDescription?.text = currentNote.description
            Snackbar.make(tvDescription as View, currentNote.date, Snackbar.LENGTH_SHORT).show()
        }
    }

    fun setNotes(notes: List<Note>) {
        itemLists = notes
        notifyDataSetChanged()
    }
}
