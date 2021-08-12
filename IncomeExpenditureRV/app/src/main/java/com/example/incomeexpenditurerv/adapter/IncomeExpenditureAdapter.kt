package com.example.incomeexpenditurerv.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.incomeexpenditurerv.R
import com.example.incomeexpenditurerv.data.IncomeExpenditure
import kotlinx.android.synthetic.main.row.view.*

class IncomeExpenditureAdapter : RecyclerView.Adapter<IncomeExpenditureAdapter.ViewHolder>{

    var incomeExpenditureList = mutableListOf<IncomeExpenditure>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView = LayoutInflater.from(context).inflate(R.layout.row, parent)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var incomeExpenditureItem = incomeExpenditureList[position]

        holder.tvName.text = incomeExpenditureItem.name
        holder.tvPrice.text = incomeExpenditureItem.price
    }

    override fun getItemCount(): Int {
        return incomeExpenditureList.size
    }

    val context: Context
    constructor(context: Context) :super() {
        this.context = context
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tvName
        var tvPrice = itemView.tvPrice
    }

}