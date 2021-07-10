package com.example.shoplist.data

import androidx.room.*

@Dao
interface ShoppingDao {

    @Query("SELECT * FROM shoppingitems")
    fun getAllShoppingItems(): List<ShoppingList>

    @Insert
    fun insertShoppingItem(todo: ShoppingList) : Long

    @Delete
    fun deleteShoppingItem(todo: ShoppingList)

    @Update
    fun updateShoppingItem(todo: ShoppingList)

}