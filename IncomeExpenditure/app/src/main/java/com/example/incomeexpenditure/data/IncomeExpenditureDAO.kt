package com.example.incomeexpenditure.data

import androidx.room.*

@Dao
interface IncomeExpenditureDAO {

    @Query("SELECT * FROM incomeExpenditure")
    fun getAllIncomeExpenditure(): List<IncomeExpenditure>

    @Query("DELETE FROM incomeExpenditure")
    fun deleteAll(): List<IncomeExpenditure>

    @Query("SELECT SUM(price) FROM incomeExpenditure")
    fun getAll(): Int

    @Insert
    fun insertIncomeExpenditure(item: IncomeExpenditure) : Long

    @Delete
    fun deleteIncomeExpenditure(item: IncomeExpenditure)

    @Update
    fun updateIncomeExpenditure(item: IncomeExpenditure)

}