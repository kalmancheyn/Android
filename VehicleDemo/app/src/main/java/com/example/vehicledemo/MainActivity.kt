package com.example.vehicledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myVehicle = Vehicle("abc-123")
        var myShip = Ship("abc-234", 34)

        println("""
            myCar: ${myVehicle.showPlateNum()}
            myShip: ${myShip.showPlateNumAndSize()}
        """.trimIndent())
    }
}