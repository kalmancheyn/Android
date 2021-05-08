package com.example.vehicledemo

class FuelEngine(plateNum: String, carBrand: String, carType: String, var fuelType: String, var engineSize: Int): Car(plateNum, carBrand, carType) {

    fun showAll(): String {
        return "$plateNum, $carBrand, $carType, $fuelType, $engineSize"
    }

}