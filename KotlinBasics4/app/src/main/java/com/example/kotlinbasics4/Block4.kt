package com.example.kotlinbasics4

fun main() {
    var list = mutableListOf(1,2,3,4,5)
    //val convertedList = convertListItems(list, {item: Int -> item.toString() + " Ft"})
    val convertedList = convertListItems(list){item: Int -> item.toString() + " Ft"}

    println(convertedList)

    val someList: List<Int> = listOf(1,12,3,46,8,4,55,66)
    //someList.filter { item: Int -> item % 2 == 0}.sortedBy({ item: Int -> item }).map({ item: Int -> item * 2 }).forEach({item -> print("$item ")})
    someList.filter { it % 2 == 0 }.sortedBy { it }.map { it * 2 }.forEach{ print("$it ")}
}

fun convertListItems(list: List<Int>, convert: (Int) -> String): List<String>{
    var result : MutableList<String> =  mutableListOf()
    for (index in 0..list.size - 1){
        result.add(convert(list.get(index)))
    }
    return result
}