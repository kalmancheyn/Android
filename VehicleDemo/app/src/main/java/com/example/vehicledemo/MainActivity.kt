package com.example.vehicledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myVehicle = Vehicle("abc-123")
        val myShip = Ship("abc-234", 34)
        val myWheeledVehicle = WheeledVehicle("abc-345")
        val myCar = Car("abc-456", "Tesla", "ModelS")
        val myFuelEngine = FuelEngine("abc-567", "Mustang", "GT", "Petrol", 6000)
        val myElectricCar = ElectricCar("abc-678", "Porshe", "Taycan", 800)

        tvData.setOnClickListener() {
            tvData.text = """
            myCar: ${myVehicle.showPlateNum()}
            myShip: ${myShip.showPlateNumAndSize()}
            myWheeledVehicle: ${myWheeledVehicle.showPlatenNumAndEngineType()}
            myCar: ${myCar.showPlateBrandType()}
            myFuelEngine ${myFuelEngine.showAll()}
            myElectricCar ${myElectricCar.showAll()}
        """.trimIndent()
        }
    }
}