package webuni.weather.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import webuni.weather.data.WeatherResult

// HOST:  http://api.openweathermap.org
// PATH: /data/2.5/weather
// QUERY/URL params: ?q=Budapest&units=metric&appid=f3d694bc3e1d44c1ed5a97bd1120e8fe

interface WeatherAPI {

    @GET("/data/2.5/weather")
    fun getPlace(@Query("q") q: String,
                 @Query("units") units: String,
                 @Query("appid") appid: String): Call<WeatherResult>

}