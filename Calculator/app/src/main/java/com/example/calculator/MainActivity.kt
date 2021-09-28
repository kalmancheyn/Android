package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val calculator = Calculator()
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.tvResult)

    }

    fun onNumberClickHandler(view: View) {
        val button = view as Button

        when (button.text) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                result.append(button.text)

            }
            "+", "-", "/", "*" -> {
                result.text = calculator.calculate(result.text as String)
                result.append(button.text)
            }

            "=" -> {
                result.text = calculator.calculate(result.text as String)
            }

            "DEL" -> {
                result.text = "0"
            }
        }
    }
}