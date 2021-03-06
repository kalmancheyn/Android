package com.example.todorecylerviewdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.todorecylerviewdemo.R
import com.example.todorecylerviewdemo.ScrollingActivity
import com.example.todorecylerviewdemo.data.AppDatabase
import com.example.todorecylerviewdemo.data.Todo
import com.example.todorecylerviewdemo.touch.todoTouchHelperCallback
import kotlinx.android.synthetic.main.todo_row.view.*
import java.util.*

class todoAdapter : RecyclerView.Adapter<todoAdapter.ViewHolder>, todoTouchHelperCallback{

    var todoItems = mutableListOf<Todo>()

    val context: Context
    constructor(context: Context,todoList: List<Todo>): super() {
        this.context = context
        todoItems.addAll(todoList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val todoView = LayoutInflater.from(context).inflate(R.layout.todo_row, parent, false)
        return ViewHolder(todoView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var todoItem = todoItems[position]

        holder.tvDate.text = todoItem.createDate
        holder.cbDone.isChecked = todoItem.done
        holder.cbDone.text = todoItem.todoText
        holder.btnDel.setOnClickListener {
            deleteTodo(holder.adapterPosition)
        }
    }

    fun addTodo(todo: Todo) {
        todoItems.add(todo)
        notifyItemInserted(todoItems.lastIndex)
    }

    override fun getItemCount(): Int {
        return  todoItems.size
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var tvDate = itemView.tvDate
        var cbDone = itemView.cbDone
        var btnDel = itemView.btnDel
    }

    fun deleteTodo(position: Int) {

        var todoToDelete = todoItems.get(position)
        Thread {
            AppDatabase.getInstance(context).todoDao().deleteTodo(todoToDelete)

            (context as ScrollingActivity).runOnUiThread {
                todoItems.removeAt(position)
                notifyItemRemoved(position)
            }
        }.start()
    }

    override fun onDismissed(position: Int) {
        deleteTodo(position)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(todoItems, fromPosition, toPosition)
        notifyItemMoved(fromPosition,toPosition)
    }


}