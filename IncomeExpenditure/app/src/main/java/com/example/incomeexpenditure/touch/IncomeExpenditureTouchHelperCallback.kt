package com.example.incomeexpenditure.touch

interface IncomeExpenditureTouchHelperCallback {
    fun onDismissed(position: Int)
    fun onItemMoved(fromPosition: Int, toPosition: Int)
}