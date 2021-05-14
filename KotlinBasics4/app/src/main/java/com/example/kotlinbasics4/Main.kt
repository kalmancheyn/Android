package com.example.kotlinbasics4

import com.example.lib.HttpRequest
import com.example.lib.timeOut

fun main() {
    Calculator().max(1,2)

    val httpRequest: HttpRequest = HttpRequest()
    httpRequest.sendRequest()

    timeOut = 90
}