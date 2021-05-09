package com.example.vehicledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var myVehicle = Vehicle("abc-123")
        val myShip = Ship("VitorlásGyár")
        val myWheeledVehicle = WheeledVehicle("abc-345")
        val myCar = Car("abc-456", "Tesla", "ModelS")
        val myFuelEngine = FuelEngine("abc-567", "Mustang", "GT", "Petrol", 6000)
        val myElectricCar = ElectricCar("abc-678", "Porshe", "Taycan", 800)

        tvData.setOnClickListener() {
            tvData.text = """
                myship: ${myShip.shipManufacturer} ${myShip.startVehicle()} ${myShip.loadThis()}
            """.trimIndent()
        }
    }
}