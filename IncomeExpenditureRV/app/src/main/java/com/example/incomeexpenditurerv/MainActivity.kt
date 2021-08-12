package com.example.incomeexpenditurerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incomeexpenditurerv.adapter.IncomeExpenditureAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterIncome: IncomeExpenditureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterIncome = IncomeExpenditureAdapter(this)
        recyclerView.adapter = adapterIncome

    }
}