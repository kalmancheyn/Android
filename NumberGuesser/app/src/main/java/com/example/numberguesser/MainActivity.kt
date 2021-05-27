package com.example.numberguesser

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var randNum = (0..100).random()
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Barkóba"

        Guesser()
    }

    private fun Guesser() {
        btnGuess.setOnClickListener {
            if (etGuess.text.isNotEmpty()) {
                if (etGuess.text.toString().toInt() in 0..100) {
                    if (randNum == etGuess.text.toString().toInt()) {
                        tvResult.setTextColor(Color.parseColor("#00FF00"))
                        tvResult.text = "Telitalálat!!!"
                        tvInstruction.text = "Új szám generálva. \nKérem tippeljen! \n(1 és 100 között)"
                        tvGuesses.text = "Eddigi tippek: "
                        tvNumOfGuess.text = "Eddigi tippek száma: "
                        counter = 0
                        newRandNum()
                    } else if (randNum > etGuess.text.toString().toInt()) {
                        changeInstruction()
                        setColorRed()
                        tvResult.text = "A szám nagyobb!"
                        addGuessToTv()
                        addToCounter()
                    } else {
                        changeInstruction()
                        setColorRed()
                        tvResult.text = "A szám kisebb!"
                        addGuessToTv()
                        addToCounter()
                    }
                    etGuess.text.clear()
                } else {
                    etGuess.error = "Csak 0 és 100 közötti számot lehet megadni."
                }
            } else {
                etGuess.error = "Meg kell adnia egy tippet."
            }
        }
    }

    private fun changeInstruction() {
        var str = "Kérem tippeljen! \n(1 és 100 között)"
        if (tvInstruction.text != str) {
            tvInstruction.text = str
        }
    }

    private fun newRandNum (): Int {
        var previusNum = randNum
        while (randNum == previusNum) {
            randNum = (0..100).random()
        }
        return randNum
    }

    private fun setColorRed () {
        tvResult.setTextColor(Color.parseColor("#FF0000"))
    }

    private fun addGuessToTv () {
        tvGuesses.append("${etGuess.text.toString().toInt()}, ")
    }

    private fun addToCounter () {
        counter++
        tvNumOfGuess.text = "Eddigi tippek száma: $counter"
    }

}
