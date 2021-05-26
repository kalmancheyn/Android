package com.example.numberguesser

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var randNum = (0..100).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Barkóba"

        Guesser()
    }

    private fun Guesser() {
        var counter = 0
        btnGuess.setOnClickListener {
            if (etGuess.text.isNotEmpty()) {
                if (randNum == etGuess.text.toString().toInt()) {
                    tvResult.setTextColor(Color.parseColor("#00FF00"))
                    tvResult.text = "Telitalálat!!!"
                    tvInstruction.text = "Új szám generálva. \nKérem tippeljen! \n(1 és 100 között)"
                    tvGuesses.text = "Eddigi tippek: "
                    newRandNum()
                } else if (randNum > etGuess.text.toString().toInt()) {
                    changeInstruction()
                    setColorRed()
                    tvResult.text = "A szám nagyobb!"
                } else {
                    changeInstruction()
                    setColorRed()
                    tvResult.text = "A szám kisebb!"
                }
                counter++
                tvNumOfGuess.text = "Eddigi tippek száma: $counter"
                tvGuesses.append("${etGuess.text.toString().toInt()}, ")
            } else {
                etGuess.error = "Meg kell adnia egy tippet"
            }
        }
    }

    fun changeInstruction() {
        var str = "Kérem tippeljen! \n(1 és 100 között)"
        if (tvInstruction.text != str) {
            tvInstruction.text = str
        }
    }

    fun newRandNum (): Int {
        var previusNum = randNum
        while (randNum == previusNum) {
            randNum = (0..100).random()
        }
        return randNum
    }

    fun setColorRed () {
        tvResult.setTextColor(Color.parseColor("#FF0000"))
    }

}

