package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    lateinit var result : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        result = findViewById(R.id.editText)
    }

    fun secondButton(view: View) {

    }
    fun editText(view: View) {
        val text : String = result.text as String
        val intenet = Intent()

        intenet.putExtra("result", text)

        setResult(RESULT_OK, intenet)
        finish()
    }

}