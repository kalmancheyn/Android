package com.example.vehicledemo

abstract class Vehicle(var manifacturer: String){

    abstract fun startVehicle()

    fun showManufacture() {
        println("$manifacturer")
    }

}