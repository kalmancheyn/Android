package com.example.kotlinobjectorienteddemo

class Car(var plateNumber: String){

    var upperPlateNumber: String = ""
        get() {
            return "$field hello"
        }
        set(value: String) {
            field = "DEMO $value"
        }
    var engineNum = 0

    init {
        upperPlateNumber = plateNumber.toUpperCase()
    }

    constructor(aPlate: String, engineNum: Int): this(aPlate){
        this.engineNum = engineNum
    }

    fun showPlateNumber(): String {
        return upperPlateNumber
    }

    fun showPlateAndEngine(): String {
        return "$upperPlateNumber, $engineNum"
    }

}