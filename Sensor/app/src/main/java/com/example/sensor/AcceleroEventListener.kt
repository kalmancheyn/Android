package com.example.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.TextView

class AcceleroEventListener(var textView: TextView): SensorEventListener {

    override fun onSensorChanged(event: SensorEvent?) {
        textView.text = event!!.values[0].toString()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}