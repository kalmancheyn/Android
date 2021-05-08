package com.example.kotlinobjectorienteddemo

fun main(args: Array<String>) {

    var myCar = Car("abc-123", 1233112)

    //println(myCar.showPlateAndEngine())
    //tvData.text = myCar.showPlateAndEngine()

    var myElectricCar = ElectricCar("zöld")
    println(myElectricCar.showPlateNumber())
}