package com.example.shoplist.touch

import java.text.FieldPosition

interface ShoppingListTouchHelperCallback {
    fun onDismissed(position: Int)
    fun onItemMoved(fromPosition: Int, toPosition: Int)
}