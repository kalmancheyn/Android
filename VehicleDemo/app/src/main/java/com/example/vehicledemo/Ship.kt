package com.example.vehicledemo

interface Loadable{
    fun loadThis()
}

class Ship(var shipManufacturer: String) : Vehicle(shipManufacturer), Loadable {
    override fun startVehicle() {
        println("Zászlót fel")
    }

    override fun loadThis() {
        println("Feltöltve")
    }


}