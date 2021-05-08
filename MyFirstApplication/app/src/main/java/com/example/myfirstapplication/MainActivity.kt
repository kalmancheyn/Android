package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDemo.setOnClickListener(::demoClick)
    }

    private fun demoClick(view: View){
        //tvData.text = "HAHO Működik ${Date(System.currentTimeMillis()).toString()}"
        demoStrings()
    }

    fun demoVariables() {
        var a = 10
        a = 20
        println("Num: $a")
    }

    private fun demoArrays() {
        var myNums = intArrayOf(2,3,4,5,6)
        var myMixedArrey = arrayOf(2, "demo", true)
        tvData.text = myMixedArrey[1].toString()
    }

    private fun demoStrings() {
        var num1 = 5
        var num2 = 7
        //tvData.text = "Num1: $num1\nNum2: $num2\nSum is:\n ${num1+num2}"
        tvData.text = """
            Num1: $num1
            Num2: $num2
            Sum is: ${num1+num2}
        """.trimIndent()
    }

    fun arreysDemo1() {
        var numbers : ArrayList<Int> = ArrayList()
        numbers.add(4)
        numbers.add(2)
        numbers.add(5)
        numbers.add(7)
        numbers.add(3)
        println("Unsorted array: $numbers")
        numbers.sort()
        println("Sorted array: $numbers")
        numbers.shuffle()
        println("Shuffle array: $numbers")
        numbers.reverse()
        println("Reverse array: $numbers")
        Collections.swap(numbers, 0, 1)
        val newNumbers : ArrayList<Int?> = ArrayList()
        newNumbers.addAll(numbers)

        newNumbers.fill(1)

        Collections.binarySearch(numbers, 3) //csak rendezett tömbön megy

        var count = Collections.frequency(numbers, 2)

        val numbers2 : ArrayList<Int> = ArrayList()
        numbers2.add(444)
        numbers2.add(22)

        val value = Collections.disjoint(numbers, numbers2)
        println("Two lisat are disjunkt: $value")

    }
}