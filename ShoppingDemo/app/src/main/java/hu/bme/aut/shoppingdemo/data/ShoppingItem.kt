package hu.bme.aut.shoppingdemo.data

data class ShoppingItem(
    var name: String,
    var price: Int,
    var description: String,
    var bought: Boolean,
    var category: Int
)