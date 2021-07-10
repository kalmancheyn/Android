package com.example.shoplist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "shoppingItems")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true) var itemId: Long?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "bought") var bought : Boolean,
    @ColumnInfo(name = "category") var category: Int,
    @ColumnInfo(name = "description") var description: String
) : Serializable