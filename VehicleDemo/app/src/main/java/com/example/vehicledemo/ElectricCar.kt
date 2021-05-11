package com.example.vehicledemo

class ElectricCar(plateNum: String, carBrand: String, carType: String, var horsePower: Int) : Car(plateNum, carBrand, carType) {
    
    fun showAll(): String {
        return "$plateNum, $carBrand, $carType, $horsePower"
    }
}