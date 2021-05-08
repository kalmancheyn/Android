package com.example.vehicledemo

class Ship(plateNum: String) : Vehicle(plateNum) {

    private var size: Int  = 0

    constructor(plateNum: String, size: Int): this(plateNum) {
        this.size = size
    }

    fun showPlateNumAndSize(): String {
        return "plateNum: $plateNum Size: $size"
    }

}