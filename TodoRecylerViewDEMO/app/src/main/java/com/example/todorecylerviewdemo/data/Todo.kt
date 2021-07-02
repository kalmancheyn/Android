package com.example.todorecylerviewdemo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true) val todoId: Long?,
    @ColumnInfo(name = "createData") var createDate: String,
    @ColumnInfo(name = "dane")var done: Boolean,
    @ColumnInfo(name = "todoText")var todoText: String
)
