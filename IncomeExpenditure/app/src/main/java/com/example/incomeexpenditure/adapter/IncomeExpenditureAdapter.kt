package com.example.incomeexpenditure.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.incomeexpenditure.R
import com.example.incomeexpenditure.ScrollingActivity
import com.example.incomeexpenditure.data.AppDatabase
import com.example.incomeexpenditure.data.IncomeExpenditure
import kotlinx.android.synthetic.main.row.view.*
import java.lang.Exception

class IncomeExpenditureAdapter : RecyclerView.Adapter<IncomeExpenditureAdapter.ViewHolder>{

    var incomeExpenditureList = mutableListOf<IncomeExpenditure>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView = LayoutInflater.from(context).inflate(R.layout.row, parent,false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var incomeExpenditureItem = incomeExpenditureList[position]

        holder.tvName.text = incomeExpenditureItem.name
        holder.tvPrice.text = incomeExpenditureItem.price

        if (incomeExpenditureList[position].category == 0) {
            holder.tvType.text = "Kiadás:"
        } else {
            holder.tvType.text = "Bevétel:"
        }

        holder.btnDelet.setOnClickListener {
            deleteItem(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return incomeExpenditureList.size
    }

    val context: Context
    constructor(context: Context, incomeList: List<IncomeExpenditure>) :super() {
        this.context = context
        incomeExpenditureList.addAll(incomeList)
    }

    private fun deleteItem(position: Int) {
        try {
            var itemToDelete = incomeExpenditureList.get(position)
            Thread {
                AppDatabase.getInstance(context).incomeExpenditureDAO()
                    .deleteIncomeExpenditure(itemToDelete)

                (context as ScrollingActivity).runOnUiThread {
                    incomeExpenditureList.removeAt(position)
                    notifyItemRemoved(position)
                }
            }.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addItem(item: IncomeExpenditure) {
        incomeExpenditureList.add(item)
        notifyItemInserted(incomeExpenditureList.lastIndex)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tvName
        var tvPrice = itemView.tvPrice
        var tvType = itemView.tvType
        var btnDelet = itemView.btnDelete
    }

}