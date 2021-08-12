package com.example.incomeexpenditurerv.data

import androidx.room.*

@Dao
interface IncomeExpenditureDAO {

    @Query("SELECT * FROM incomeExpenditure")
    fun getAllIncomeExpenditure(): List<IncomeExpenditure>

    @Insert
    fun insertIncomeExpenditure(todo: IncomeExpenditure) : Long

    @Delete
    fun deleteIncomeExpenditure(todo: IncomeExpenditure)

    @Update
    fun updateIncomeExpenditure(todo: IncomeExpenditure)

}