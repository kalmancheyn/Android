package hu.bme.aut.shoppingdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.shoppingdemo.R
import hu.bme.aut.shoppingdemo.data.ShoppingItem
import hu.bme.aut.shoppingdemo.databinding.ShopItemBinding
import kotlinx.android.synthetic.main.shop_item.view.*

class ShoppingAdapter : RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {

    private val items = mutableListOf<ShoppingItem>()
    private val context: Context

    constructor(context: Context, itemsList: List<ShoppingItem>) : super() {
        this.context = context
        items.addAll(itemsList)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val shopItemBinding = ShopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(shopItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {


            tvName.text = items[position].name
            tvPrice.text = items[position].price.toString()
            cbBought.isChecked = items[position].bought

            when (items[position].category) {
                0 -> {
                    ivItemLogo.setImageResource(R.drawable.food)
                }
                1 -> {
                    ivItemLogo.setImageResource(R.drawable.clothes)
                }
                2 -> {
                    ivItemLogo.setImageResource(R.drawable.sport)
                }
            }

            btnDelete.setOnClickListener {
                deleteItem(holder.adapterPosition)
            }
        }
    }

    private fun deleteItem(adapterPosition: Int) {
        items.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: ShoppingItem) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
        //notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ShopItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

}