package android.shoppinglist

import android.os.Bundle
import android.shoppinglist.adapter.ShoppingAdapter
import android.shoppinglist.data.ShoppingList
import android.shoppinglist.dialog.ShoppingDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), ShoppingDialog.ShoppingHandler {

    lateinit var shopAdapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))

        shopAdapter = ShoppingAdapter(this)
        rvShopping.adapter = shopAdapter

        fab.setOnClickListener {
            ShoppingDialog().show(supportFragmentManager, "Dialog")
        }

    }

    override fun itemCreated(shop: ShoppingList) {
        shopAdapter.addItem(shop)
    }
}