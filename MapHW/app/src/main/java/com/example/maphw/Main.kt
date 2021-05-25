package com.example.maphw

import java.util.*

fun main() {
    var firstEmlpoyee = Employee("Kis Józsi", "1995.07.15", "Nyíregyháza Kéz utca 13", 5)
    var mapForEmploy = mutableMapOf<Int, Employee>()
    mapForEmploy[1] = firstEmlpoyee


    println(mapForEmploy.toString())
}


//fun main() {
//    var company = mutableMapOf( UUID.randomUUID().toString() to Person("John Doe", 1981, "New York", 15), UUID.randomUUID().toString() to Person("Jack", 1991, "Zalaegerszeg", 15), UUID.randomUUID().toString() to Person("Alex", 1945, "Debrecen", 15), UUID.randomUUID().toString() to Person("Sue", 1921, "Siófok", 15), UUID.randomUUID().toString() to Person("Anna", 1971, "Budapest", 15) )
//    company.put(UUID.randomUUID().toString(), Person("Stephen", 1999, "Érd", 12) )
//    var youngMembers = company.filter { (key, value) -> value.birthYear>1980 && value.yearAtCompany>10 }
//    youngMembers.forEach { println("${it.key}, ${it.value.name}") }
//}