package com.thiha.roomexe.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.thiha.roomexe.R

/**
project: RoomExe
Created by : Thiha
date : 6/25/2020
 */
class AddEditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnoteedit)

        val etTitle: EditText = findViewById(R.id.et_title)
        val etDescription: EditText = findViewById(R.id.et_description)
        val btnSave: Button = findViewById(R.id.btn_save)

        btnSave.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(etTitle.text.toString().trim())) {
                etTitle.error = "Input Title"
                etTitle.requestFocus()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(etDescription.text.toString().trim())) {
                etDescription.error = "Input Description"
                etDescription.requestFocus()
                return@setOnClickListener
            }

            replyIntent.putExtra(INTENT_TITLE, etTitle.text.toString().trim())
            replyIntent.putExtra(INTENT_DESCRIPTION, etDescription.text.toString().trim())
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }

    companion object {
        const val INTENT_TITLE = "title"
        const val INTENT_DESCRIPTION = "description"
    }
}