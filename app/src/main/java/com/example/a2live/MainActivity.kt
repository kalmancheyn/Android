package com.example.a2live

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a2live.data.shop.Food
import com.example.a2live.data.shop.Shop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var shop = Shop()

        shop.foods.add(Food("hal", 1000))
        shop.foods.add(Food("kenyér", 250))

        shop.foods.forEach {
            it.buy()
        }
    }
}