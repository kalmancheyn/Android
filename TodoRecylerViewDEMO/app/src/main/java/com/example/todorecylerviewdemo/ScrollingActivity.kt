package com.example.todorecylerviewdemo

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todorecylerviewdemo.adapter.todoAdapter
import com.example.todorecylerviewdemo.data.AppDatabase
import com.example.todorecylerviewdemo.data.Todo
import com.example.todorecylerviewdemo.databinding.ActivityScrollingBinding
import com.example.todorecylerviewdemo.touch.todoRecyclerTouchCallback
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), TodoDialog.TodoHandler {

    private lateinit var binding: ActivityScrollingBinding
    lateinit var todoAdapter: todoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        initRecyclerView()


        fab.setOnClickListener {
            TodoDialog().show(supportFragmentManager, "Dialog")
        }

    }

    private fun initRecyclerView() {

        Thread {
            var todoList =AppDatabase.getInstance(this@ScrollingActivity).todoDao().getAllTodo()

            runOnUiThread {
                todoAdapter = todoAdapter(this, todoList)
                recyclerTodo.adapter = todoAdapter
                //recyclerTodo.layoutManager = GridLayoutManager(this, 2)
                //recyclerTodo.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

                val touchCallBack = todoRecyclerTouchCallback(todoAdapter)
                val itemTouchHelper = ItemTouchHelper(touchCallBack)
                itemTouchHelper.attachToRecyclerView(recyclerTodo)
            }
        }.start()
    }

    override fun todoCreated(todo: Todo) {

        Thread{
            AppDatabase.getInstance(this@ScrollingActivity).todoDao().insertTodo(todo)
            runOnUiThread {
                todoAdapter.addTodo(todo)
            }

        }.start()
    }
}

