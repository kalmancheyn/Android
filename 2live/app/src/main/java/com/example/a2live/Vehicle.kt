package com.example.a2live

abstract class Vehicle {

    fun goSomeWhere() {
        //..
    }
}

abstract class VehicleWithWheels: Vehicle() {

    fun pumpWheels() {
        //..
    }
}

interface Reanable {
    fun rent()
}

interface Taxi {
    fun earnMoney()
}

class Car: VehicleWithWheels(), Reanable, Taxi {
    override fun rent() {

    }

    override fun earnMoney() {

    }

}