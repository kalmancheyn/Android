package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var gender : Boolean? = null

        var maleBtnPressed = 0
        var femaleBtnPressed = 0

        btnMale.setOnClickListener {
            changeMaleBtnBackgroundChanged()
            gender = true
            maleBtnPressed = 1

            if (femaleBtnPressed == 1) {
                changeFemaleBtnBackgroundDefault()
                femaleBtnPressed = 0
            }
        }

        btnFemale.setOnClickListener {
            changeFemaleBtnBackgroundChanged()
            gender = false
            femaleBtnPressed = 1

            if (maleBtnPressed == 1) {
                changeMaleBtnBackgroundDefault()
                maleBtnPressed = 0
            }
        }

        sbHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, height: Int, b: Boolean) {
                // Display the current progress of SeekBar
                tvHeightResult.text = "$height cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }
        })

        sbAge.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, age: Int, b: Boolean) {
                // Display the current progress of SeekBar
                tvAgeResult.text = "$age"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }
        })

        sbWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, weight: Int, b: Boolean) {
                // Display the current progress of SeekBar
                tvWeightResult.text = "$weight kg"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"",Toast.LENGTH_SHORT).show()
            }
        })

        var bmiIndex : Float

        btnCalculate.setOnClickListener {
            bmiIndex = sbWeight.progress.toFloat()/((sbHeight.progress.toFloat()/100)*(sbHeight.progress.toFloat()/100))
            if (gender == null) {
                tvResult.text = "Kérem adja meg a nemét!"
            } else {
                if (bmiIndex < 18.5) {
                tvResult.text = "Sovány"
            } else if (bmiIndex < 25) {
                tvResult.text = "Normál testsúly"
            } else if (bmiIndex <30) {
                tvResult.text = "Túlsúlyos"
            } else {
                tvResult.text = "Elhízott"
            }
            }
        }



    }

    fun changeFemaleBtnBackgroundDefault() {
        btnFemale.setBackgroundColor(ContextCompat.getColor(this, R.color.light_grey))
        btnFemale.setTextColor(ContextCompat.getColor(this, R.color.white))
    }
    fun changeMaleBtnBackgroundDefault() {
        btnMale.setBackgroundColor(ContextCompat.getColor(this, R.color.light_grey))
        btnMale.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    fun changeFemaleBtnBackgroundChanged() {
        btnFemale.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_grey))
        btnFemale.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    fun changeMaleBtnBackgroundChanged() {
        btnMale.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_grey))
        btnMale.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}