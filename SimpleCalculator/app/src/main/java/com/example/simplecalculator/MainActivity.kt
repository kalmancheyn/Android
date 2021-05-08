package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Calculator"

        btnPlus.setOnClickListener {
            if (isFormValid()) {
                tvResult.text = "Eredmény: ${etNum1.text.toString().toInt()+etNum2.text.toString().toInt()}"
            }
        }

        btnMinus.setOnClickListener {
            if (isFormValid()) {
                tvResult.text = "Eredmény ${etNum1.text.toString().toInt() - etNum2.text.toString().toInt()}"
            }
        }

        btnMultiplication.setOnClickListener {
            if (isFormValid()) {
                tvResult.text = "Eredmény ${etNum1.text.toString().toInt() * etNum2.text.toString().toInt()}"
            }
        }

        btnDivision.setOnClickListener {
            if (isFormValid()) {
                tvResult.text = "Eredmény ${etNum1.text.toString().toFloat() / etNum2.text.toString().toFloat()}"
            }
        }
    }

    private fun isFormValid(): Boolean {
        if (etNum1.text.isEmpty()) {
            etNum1.error = "Ez a mező nem lehet üres!"
            return false
        }
        if (etNum2.text.isEmpty()) {
            etNum2.error = "Ez a mező nem lehet üres!"
            return false
        }
        return true
    }
}