package com.example.todorecylerviewdemo.touch

interface todoTouchHelperCallback {
    fun onDismissed(position: Int)
    fun onItemMoved(fromPosition: Int, toPosition: Int)
}
