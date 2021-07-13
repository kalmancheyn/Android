package com.example.shoplist.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.ScrollingActivity
import com.example.shoplist.data.AppDatabase
import com.example.shoplist.data.ShoppingList
import com.example.shoplist.touch.ShoppingListTouchHelperCallback
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.*

class ShoppingAdapter : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>, ShoppingListTouchHelperCallback{

    var shopItems = mutableListOf<ShoppingList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val shopView = LayoutInflater.from(context).inflate(R.layout.item_row, parent,false)
        return ViewHolder(shopView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var shopItem = shopItems[position]
        holder.tvName.text = shopItem.name
        holder.tvPrice.text = shopItem.price
        holder.cbBought.isChecked = shopItem.bought
        holder.tvDescripton.text = shopItem.description

        if (shopItems[position].category == 0) {
            holder.ivItemLogo.setImageResource(R.drawable.food)
        }
        else if (shopItems[position].category == 1) {
            holder.ivItemLogo.setImageResource(R.drawable.clothes)
        }
        else if (shopItems[position].category == 2) {
            holder.ivItemLogo.setImageResource(R.drawable.sport)
        }

        holder.btnDelete.setOnClickListener {
            deleteItem(holder.adapterPosition)
        }

    }

    fun deleteItem(position: Int) {
        try {
            var itemToDelete = shopItems.get(position)
            Thread {
                AppDatabase.getInstance(context).shoppingDao().
                deleteShoppingItem(itemToDelete)

                (context as ScrollingActivity).runOnUiThread {
                    shopItems.removeAt(position)
                    notifyItemRemoved(position)
                }
            }.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return shopItems.size
    }

    val context: Context
    constructor(context: Context, shoppingItemList: List<ShoppingList>) : super() {
        this.context = context
        shopItems.addAll(shoppingItemList)
    }

    fun addItem(shop: ShoppingList) {
        shopItems.add(shop)
        notifyItemInserted(shopItems.lastIndex)
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tvName
        var tvPrice = itemView.tvPrice
        var cbBought = itemView.cbBought
        var ivItemLogo = itemView.ivItemLogo
        var btnDelete = itemView.btnDelete
        var tvDescripton = itemView.tvDescription
    }

    override fun onDismissed(position: Int) {
        deleteItem(position)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(shopItems, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

}