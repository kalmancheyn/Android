package com.example.vehicledemo

open class WheeledVehicle(platenNum: String) : Vehicle(platenNum) {

    fun showPlatenNumAndEngineType() : String{
        return "$plateNum"
    }

}