package com.example.kotlinobjectorienteddemo

class ElectricCar(plateNum: String) : Car(plateNum) {

    fun charge() {

    }

    override fun showPlateAndEngine(): String {
        super.showPlateAndEngine()
        return "zöld - elektromotor"
    }

}