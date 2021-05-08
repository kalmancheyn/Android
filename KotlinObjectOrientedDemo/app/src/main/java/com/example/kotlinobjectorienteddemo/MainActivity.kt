package com.example.kotlinobjectorienteddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myCar = Car("abc-123", 1233112)

        println(myCar.showPlateAndEngine())

        tvData.text = myCar.showPlateAndEngine()

    }
}