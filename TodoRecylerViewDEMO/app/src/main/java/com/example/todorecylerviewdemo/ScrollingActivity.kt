package com.example.todorecylerviewdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todorecylerviewdemo.adapter.todoAdapter
import com.example.todorecylerviewdemo.data.AppDatabase
import com.example.todorecylerviewdemo.data.Todo
import com.example.todorecylerviewdemo.databinding.ActivityScrollingBinding
import com.example.todorecylerviewdemo.touch.todoRecyclerTouchCallback
import kotlinx.android.synthetic.main.activity_scrolling.*
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import java.util.*

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

        if (isFirtsStart()) {
            MaterialTapTargetPrompt.Builder(this).setTarget(R.id.fab)
                .setPrimaryText("Create Todo")
                .setSecondaryText("Click here to create new todo")
                .show()
        }

        saveData()
    }

    companion object{
        const val PREF_SETTINGS = "PREF_SETTINGS"
        const val KEY_LAST_OPENED = "KEY_LAST_OPENED"
        const val KEY_FIRST_START = "KEY_FIRST_START"
    }

    private fun saveData() {
        val sp = getSharedPreferences(PREF_SETTINGS, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(KEY_LAST_OPENED, Date(System.currentTimeMillis()).toString())
        editor.putBoolean(KEY_FIRST_START, false)
        editor.commit()
    }

    private fun isFirtsStart(): Boolean {
        val sp = getSharedPreferences(PREF_SETTINGS, Context.MODE_PRIVATE)
        val lastOpened = sp.getString(KEY_LAST_OPENED, "This is the first time.")
        Toast.makeText(this, lastOpened, Toast.LENGTH_LONG).show()
        return sp.getBoolean(KEY_FIRST_START, true)
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

