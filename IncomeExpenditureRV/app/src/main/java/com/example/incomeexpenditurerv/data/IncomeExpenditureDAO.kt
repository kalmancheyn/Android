package com.example.incomeexpenditurerv.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface IncomeExpenditureDAO {

    @Query("SELECT * FROM incomeExpenditure")
    fun getAllShoppingItems(): List<IncomeExpenditure>

    @Insert
    fun insertShoppingItem(todo: IncomeExpenditure) : Long

    @Delete
    fun deleteShoppingItem(todo: IncomeExpenditure)

    @Update
    fun updateShoppingItem(todo: IncomeExpenditure)

}