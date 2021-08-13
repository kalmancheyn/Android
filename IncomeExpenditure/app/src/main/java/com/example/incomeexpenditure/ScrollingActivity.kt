package com.example.incomeexpenditure

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.incomeexpenditure.adapter.IncomeExpenditureAdapter
import com.example.incomeexpenditure.data.AppDatabase
import com.example.incomeexpenditure.data.IncomeExpenditure
import com.example.incomeexpenditure.databinding.ActivityScrollingBinding
import com.example.incomeexpenditure.dialog.IncomeExpenditureDialog
import kotlinx.android.synthetic.main.activity_scrolling.*


class ScrollingActivity : AppCompatActivity(),IncomeExpenditureDialog.DialogHandler {

private lateinit var binding: ActivityScrollingBinding

    lateinit var adapterIncome: IncomeExpenditureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

        initRecyclerView()

        fabAdd.setOnClickListener {
            IncomeExpenditureDialog().show(supportFragmentManager, "Dialog")
        }

        fabDeleteAll.setOnClickListener {
            Thread {
                var incomeList = AppDatabase.getInstance(this@ScrollingActivity).incomeExpenditureDAO().deleteAll()

                runOnUiThread {
                    adapterIncome = IncomeExpenditureAdapter(this,incomeList)
                    recyclerView.adapter = adapterIncome

                }
            }.start()
        }

    }

    private fun initRecyclerView() {
        Thread {
            var incomeList = AppDatabase.getInstance(this@ScrollingActivity).incomeExpenditureDAO().getAllIncomeExpenditure()

            runOnUiThread {
                adapterIncome = IncomeExpenditureAdapter(this, incomeList)
                recyclerView.adapter = adapterIncome

            }
        }.start()
    }

    override fun itemCreated(item: IncomeExpenditure) {
        Thread {
            var newId = AppDatabase.getInstance(this@ScrollingActivity).incomeExpenditureDAO()
                .insertIncomeExpenditure(item)
            item.itemId = newId
            runOnUiThread {
                adapterIncome.addItem(item)
            }
        }.start()
    }
}