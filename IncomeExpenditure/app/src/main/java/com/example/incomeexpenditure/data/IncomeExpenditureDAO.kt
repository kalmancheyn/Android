package com.example.incomeexpenditure.data

import androidx.room.*

@Dao
interface IncomeExpenditureDAO {

    @Query("SELECT * FROM incomeExpenditure")
    fun getAllIncomeExpenditure(): List<IncomeExpenditure>

    @Query("DELETE FROM incomeExpenditure")
    fun deleteAll(): List<IncomeExpenditure>

    @Insert
    fun insertIncomeExpenditure(item: IncomeExpenditure) : Long

    @Delete
    fun deleteIncomeExpenditure(item: IncomeExpenditure)

    @Update
    fun updateIncomeExpenditure(item: IncomeExpenditure)

}