package com.example.a2live.data.shop

interface BuyAble {
    fun buy()

    fun toBasket()
}

abstract class ShopItem(var name: String){
    fun watch() {

    }
}

class Food(var foodName: String, var  price: Int): ShopItem(foodName), BuyAble{
    override fun buy() {
        println("Megvetted a(z) $foodName nevű ételt, $price pénzért")
    }

    override fun toBasket() {
        println("Bekerült a kosárba az étel")
    }
}

class Basket(var basketName: String): ShopItem(basketName) {

}

class Device(var deviceName: String): ShopItem(deviceName), BuyAble{
    override fun buy() {
        println("Megvetted a készüléket")
    }

    override fun toBasket() {
        println("Bekerült a kosárba a készülék")
    }
}