package com.example.incomeexpenditure.data

import androidx.room.*

@Dao
interface IncomeExpenditureDAO {

    @Query("SELECT * FROM incomeExpenditure")
    fun getAllIncomeExpenditure(): List<IncomeExpenditure>

    @Query("DELETE FROM incomeExpenditure")
    fun deleteAll()

    @Query("SELECT * FROM incomeExpenditure WHERE category= :category")
    fun getIncome(category: Int): List<IncomeExpenditure>

    @Insert
    fun insertIncomeExpenditure(item: IncomeExpenditure) : Long

    @Delete
    fun deleteIncomeExpenditure(item: IncomeExpenditure)

    @Update
    fun updateIncomeExpenditure(item: IncomeExpenditure)

}