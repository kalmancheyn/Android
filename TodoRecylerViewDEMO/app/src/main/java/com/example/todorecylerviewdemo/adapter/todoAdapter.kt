package com.example.todorecylerviewdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.todorecylerviewdemo.R
import com.example.todorecylerviewdemo.data.Todo
import com.example.todorecylerviewdemo.touch.todoTouchHelperCallback
import kotlinx.android.synthetic.main.todo_row.view.*
import java.util.*

class todoAdapter : RecyclerView.Adapter<todoAdapter.ViewHolder>, todoTouchHelperCallback{

    var todoItems = mutableListOf<Todo>(
        Todo("2020.03.12", false, "Go to cinema"),
        Todo("2020.05.11", false, "Do the dishes"),
        Todo("2020.04.10", false, "Washing")
    )

    val context: Context
    constructor(context: Context): super() {
        this.context = context
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
        todoItems.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onDismissed(position: Int) {
        deleteTodo(position)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(todoItems, fromPosition, toPosition)
        notifyItemMoved(fromPosition,toPosition)
    }


}