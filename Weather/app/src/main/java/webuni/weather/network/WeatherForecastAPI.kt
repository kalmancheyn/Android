package webuni.weather.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import webuni.weather.data.WeatherForecast

// http://api.openweathermap.org/data/2.5/forecast/daily?q=Budapest&cnt=3&appid=f3d694bc3e1d44c1ed5a97bd1120e8fe

interface WeatherForecastAPI {

    @GET("/data/2.5/forecast/daily")
    fun getForecast(@Query("q") q :String,
                    @Query("cnt") cnt: Int,
                    @Query("appid") appid : String) : Call<WeatherForecast>

}