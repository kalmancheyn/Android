package com.example.a2live.data.shop

import android.bluetooth.BluetoothClass

class Shop {

    var foods = mutableListOf<Food>()
    var devices = mutableListOf<BluetoothClass.Device>()
    var internalItems = mutableListOf<BluetoothClass.Device>()

}