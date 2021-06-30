package android.shoppinglist.adapter

import android.content.Context
import android.shoppinglist.R
import android.shoppinglist.data.ShoppingList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ShoppingAdapter : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>{

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
    }

    override fun getItemCount(): Int {
        return shopItems.size
    }

    val context: Context
    constructor(context: Context) : super() {
        this.context = context
    }

    fun addItem(shop: ShoppingList) {
        shopItems.add(shop)
        notifyItemInserted(shopItems.lastIndex)
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tvName
        var tvPrice = itemView.tvPrice
        var cbBought = itemView.cbBought
    }

}