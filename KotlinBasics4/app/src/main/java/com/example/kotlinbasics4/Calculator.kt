package com.example.kotlinbasics4

import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

open class Calculator {

    public fun add(a: Int, b:Int): Int {
        return a + b
    }

    fun equals(a: Int, b:Int): Boolean {
        return a == b;
    }

    private fun multiply(a: Int, b:Int): Int {
        return a * b
    }

    protected fun min(a: Int, b:Int): Int {
        return if (a < b) a else b;
    }

    internal fun max(a: Int, b:Int): Int {
        return if (a > b) a else b;
    }

    fun divide(a: Int, b: Int): Int {
        try{
            return a/b
        } catch (exception: ArithmeticException) {
            throw DivisorZeroException()
        }
    }
}

class DivisorZeroException: Throwable("Provide divisor other then zero")

fun main() {
    println("START")
    try {
        val result = Calculator().divide(1,0)
        println(result)
    } catch (exception: DivisorZeroException) {
        //exception.printStackTrace()
        //dialógus a Hibaüzenettel
        println(exception.message)
    }

    println("END")
}