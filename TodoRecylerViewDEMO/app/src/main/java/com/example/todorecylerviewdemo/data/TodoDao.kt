package com.example.todorecylerviewdemo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDAO {

    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>

    @Insert
    fun insertTodo(vararg todo: Todo)

    @Delete
    fun deleteTodo(grade: Todo)
}