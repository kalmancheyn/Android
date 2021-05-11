package com.example.vehicledemo

open class Car(plateNum: String,var carBrand: String, var carType: String) :WheeledVehicle(plateNum) {

    fun showPlateBrandType(): String {
        return "$plateNum, $carBrand, $carType"
    }

    override fun startVehicle() {
        TODO("Not yet implemented")
    }
}