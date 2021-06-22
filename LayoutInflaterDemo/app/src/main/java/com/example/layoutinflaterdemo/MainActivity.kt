package com.example.layoutinflaterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_raw.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            var newNoteView = layoutInflater.inflate(R.layout.note_raw, null)

            newNoteView.tvData.text = etNote.text.toString()
            newNoteView.btnDel.setOnClickListener {
                layoutMain.removeView(newNoteView)
            }

            layoutMain.addView(newNoteView)
        }

    }
}