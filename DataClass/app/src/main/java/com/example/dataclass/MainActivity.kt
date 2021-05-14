 package com.example.dataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myProfile = Person("Péter", 1984)
        var (name, year) = myProfile

        /*var name = myProfile.component1()
        var year = myProfile.component2()*/

        println("$name, $year")

        var data = object {
            var a = 5
            var b = 7

            fun demo() {
                
            }
        }
    }
}

