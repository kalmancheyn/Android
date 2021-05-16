package com.example.kotlinbasics4

data class Book(val title: String, val price : Int)  {
    operator fun plus(other: Book): Int{
        return price + other.price
    }
}

operator fun Book.plus(other: Book): Int {
    return this.price + other.price - 10
}

operator fun String.times(n: Int): String {
    var result : String = ""
    for (index in 1..n) {
        result += this
    }
    return result
}

fun repeatTask(times:Int, task: () -> Unit) {
    for (index in 1..times) {
        task()
    }
}

fun main() {
    val a: Int = 1
    val b: Int = 2

    println(a + b)
    println(a.plus(b))

    val effectiveJava = Book("EffectiveJava", 200)
    val cleanCoders = Book("Clean Coders", 300)
    println(effectiveJava + cleanCoders)

    var s = "something"

    println(s*4)

    //val square : (Int) -> Int = {number -> number * number}
    //val square : (Int) -> Int = fun(number: Int):Int {return number * number}
    //val square : (Int) -> Int = fun(number):Int {return number * number}
    val square :(Int) -> Int = {it * it}

    println(square(4))

    //repeatTask(3, { println("Bake a cake!")})
    repeatTask(3){ println("Bake a cake!")}
}