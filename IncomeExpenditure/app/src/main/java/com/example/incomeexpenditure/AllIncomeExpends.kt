package com.example.incomeexpenditure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incomeexpenditure.data.AppDatabase
import kotlinx.android.synthetic.main.activity_all_income_expends.*
import kotlinx.android.synthetic.main.activity_scrolling.*

class AllIncomeExpends : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_income_expends)



        init()


    }

    private fun init() {
        var sumOfIncome = 0
        var sumOfExpends = 0
        Thread {
            var income = AppDatabase.getInstance(this@AllIncomeExpends).incomeExpenditureDAO().getIncome(1)
            var expends = AppDatabase.getInstance(this@AllIncomeExpends).incomeExpenditureDAO().getIncome(0)

            runOnUiThread {
                income.forEach {
                    sumOfIncome += (it.price).toInt()
                }
                tvIncome.text = ("$sumOfIncome Ft")

                expends.forEach {
                    sumOfExpends += (it.price).toInt()
                }
                tvExpends.text = ("$sumOfExpends Ft")

                tvBalance.append("${sumOfIncome - sumOfExpends}")
            }
        }.start()
    }

}