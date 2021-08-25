package com.example.incomeexpenditure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incomeexpenditure.adapter.IncomeExpenditureAdapter
import com.example.incomeexpenditure.data.AppDatabase
import kotlinx.android.synthetic.main.activity_all_income_expends.*
import kotlinx.android.synthetic.main.activity_scrolling.*

class AllIncomeExpends : AppCompatActivity() {

    lateinit var adapterIncome: IncomeExpenditureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_income_expends)

        Thread {
            var sumOfIncome = AppDatabase.getInstance(this@AllIncomeExpends).incomeExpenditureDAO().getAll()

            runOnUiThread {
                adapterIncome = IncomeExpenditureAdapter(this, sumOfIncome)
                tvIncome.text = sumOfIncome.toString()

            }
        }.start()
    }
}