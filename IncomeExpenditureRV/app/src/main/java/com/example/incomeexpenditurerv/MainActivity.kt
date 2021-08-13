package com.example.incomeexpenditurerv

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.incomeexpenditurerv.adapter.IncomeExpenditureAdapter
import com.example.incomeexpenditurerv.data.AppDatabase
import com.example.incomeexpenditurerv.data.IncomeExpenditure
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterIncome: IncomeExpenditureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        btnAdd.setOnClickListener {
            if (etType.text.isNotEmpty()) {
                if (etAmount.text.isNotEmpty()) {
                    handleItemCreated()
                } else {
                    etAmount.error = "This field can not be empty"
                }
            } else {
                etType.error = "This field can not be empty"
            }
        }
    }

    fun itemCreated(item: IncomeExpenditure) {
        Thread {
            var newId = AppDatabase.getInstance(this@MainActivity).incomeExpenditureDAO()
                .insertIncomeExpenditure(item)
            item.itemId = newId
            runOnUiThread {
                adapterIncome.addItem(item)
            }
        }.start()
    }

    fun handleItemCreated() {
        itemCreated(IncomeExpenditure(null, etType.text.toString(), etAmount.text.toString(),
        spinner.selectedItemPosition))
    }
}