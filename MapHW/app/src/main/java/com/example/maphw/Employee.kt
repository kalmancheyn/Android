package com.example.maphw

class Employee(var name: String, var birth: String, var address: String, var sinceEmploy: Int) {

    override fun toString(): String {
        return """
            Név: $name
            Születési dátum: $birth
            Lakcím: $address
            Alkalmazás óta eltelt évek száma: $sinceEmploy
        """.trimIndent()
    }

}