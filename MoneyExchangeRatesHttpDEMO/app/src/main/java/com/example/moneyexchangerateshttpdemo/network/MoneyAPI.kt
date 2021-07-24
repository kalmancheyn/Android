package com.example.moneyexchangerateshttpdemo.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.exchangeratesapi.io/latest?base=USD
// /latest?base=USD
// ?base=USD

interface MoneyAPI {

    @GET("/latest")
    fun getMoney(@Query("base") base: String) : Call<>

}