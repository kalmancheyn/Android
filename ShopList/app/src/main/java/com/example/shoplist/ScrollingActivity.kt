package com.example.shoplist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.shoplist.adapter.ShoppingAdapter
import com.example.shoplist.data.AppDatabase
import com.example.shoplist.data.ShoppingList
import com.example.shoplist.dialog.ShoppingDialog
import com.example.shoplist.touch.ShoppingListRecyclerTouchCallback
import com.example.shoplist.touch.ShoppingListTouchHelperCallback
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), ShoppingDialog.ShoppingHandler {

    lateinit var shopAdapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))

        initRecyclerView()

        fab.setOnClickListener {
            ShoppingDialog().show(supportFragmentManager, "Dialog")
        }

    }

    private fun initRecyclerView() {
        Thread {
            var shoppingItemList = AppDatabase.getInstance(this@ScrollingActivity).shoppingDao().getAllShoppingItems()

            runOnUiThread {
                shopAdapter = ShoppingAdapter(this, shoppingItemList)
                rvShopping.adapter = shopAdapter

                val touchCallback = ShoppingListRecyclerTouchCallback(shopAdapter)
                val itemTouchHelper = ItemTouchHelper(touchCallback)
                itemTouchHelper.attachToRecyclerView(rvShopping)

            }
        }.start()
    }


    override fun itemCreated(item: ShoppingList) {
        Thread {
            var newId = AppDatabase.getInstance(this@ScrollingActivity).shoppingDao().insertShoppingItem(item)
            item.itemId = newId
            runOnUiThread {
                shopAdapter.addItem(item)
            }
        }.start()
    }

}