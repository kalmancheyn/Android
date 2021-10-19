package com.example.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class MainActivity : AppCompatActivity(){

    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var textView: TextView
    lateinit var acceleroEventListener: AcceleroEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        textView = findViewById(R.id.tvData)
        
        acceleroEventListener = AcceleroEventListener(textView)

        sensorManager.registerListener(acceleroEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(acceleroEventListener)
    }
}