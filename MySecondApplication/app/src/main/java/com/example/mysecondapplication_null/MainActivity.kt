package com.example.mysecondapplication_null

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    var num : Int? = null
    var name : String? = null
    var numList : List<String>? = null
    var point: Point? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvData.setOnClickListener {
            //num = 10
            //var b = num?: throw IllegalArgumentException("Az érték null")
            //point = Point(2,3)
            //tvData.text = "${point?.x }"
            //tvData.text = "${point?.x }"
            // ifDemo()
            //whenDemo(2014)
            //forLoop2()
            //whileLoop()
            //demoPrint()
            // demoMethod()
            var result = myCalculatorAdd(num1 = 4, num2 = 3)
            println("SUM: $result")
        }

    }

    private fun ifDemo() {
        val score = 40
        var enoughScore = score > 80
        //println("The score is ${if (enoughScore) "" else "not"} enough")

        if (score in 10..40) {
            println("The score is between 100 and 40")
        } else {
            println("The score is neoot in range")
        }
    }

    private fun whenDemo(birthYear : Int) {
        /*var text = when(birthYear) {
            1990 -> "1990 egy jó év"
            1984 -> "Hajrá"
            in 2000..2010 -> "2000 felett"
            else -> "Egyéb"
        }
        println(text)

        println("Eredmény: ${when(birthYear) {
            1990 -> "1990 egy jó év"
            1984 -> "Hajrá"
            in 2000..2010 -> "2000 felett"
            else -> "Egyéb"
        }}")*/

        var text = when {
            birthYear < 2000 -> "2000 alatti"
            else -> "2000 feletti"
        }
        println(text)
    }

    private  fun forLoop() {
        var namesArray = arrayOf("Dénes", "Andrea", "Péter", "Éva")
        for ((index,name) in namesArray.withIndex()) {
            println("$index. $name")
        }
    }

    private  fun forLoop2() {
        for (i in 0..10) {
            println("$i ")
        }

        /*for (i in 10 downTo 1 step 2) {
            println("$i ")
        }*/
    }

    fun whileLoop() {
        var score = 0
        while ( score < 10) {
            println("Score:  $score")
            score++
        }

        var num = 10
        do {
            println("Num: $num")
            num--
        }while (num > 0)
    }

    fun demoMethod() {
        fun internalDemo() {
            println("Hahoo")
        }

        internalDemo()
    }

    fun myCalculatorAdd(num1: Int = 0, num2: Int = 0): Int {
        return num1 + num2
    }
}