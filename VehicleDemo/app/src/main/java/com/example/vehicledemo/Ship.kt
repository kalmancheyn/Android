package com.example.vehicledemo

class Ship(plateNum: String, var size: Int = 0) : Vehicle(plateNum) {


    fun showPlateNumAndSize(): String {
        return "$plateNum, $size"
    }

}