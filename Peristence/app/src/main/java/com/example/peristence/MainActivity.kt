package com.example.peristence

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.sql.Savepoint

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.etData)
        textView = findViewById(R.id.textView)
        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference_key), Context.MODE_PRIVATE)

        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString(TEXT_VIEW_KEY)
        }

        val savedValue = sharedPreferences.getString(TEXT_VIEW_KEY, "NOT_FOUND")
        if (savedValue != "NOT_FOUND"){
            textView.text = savedValue
        }

    }

    override fun onPause() {
        super.onPause()
        sharedPreferences.edit().apply {
            putString(TEXT_VIEW_KEY, textView.text.toString())
            apply()
        }

    }

    fun buttonHandler(view: View){
        textView.text = editText.text.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_VIEW_KEY, textView.text.toString())
    }

    companion object {
        const val TEXT_VIEW_KEY = "TEXT_VIEW_KEY"
    }

}