package hu.bme.aut.shoppingdemo

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import hu.bme.aut.shoppingdemo.adapter.ShoppingAdapter
import hu.bme.aut.shoppingdemo.data.ShoppingItem
import hu.bme.aut.shoppingdemo.dialog.ShoppingItemDialog
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), ShoppingItemDialog.ShoppingItemDialogHandler {

    private lateinit var adapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        adapter = ShoppingAdapter(this, mutableListOf<ShoppingItem>())
        recyclerShopping.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            ShoppingItemDialog().show(supportFragmentManager, "TAG_SHOP_DIALOG")
        }
    }

    override fun shoppingItemCreated(item: ShoppingItem) {
        adapter.addItem(item)
    }


}