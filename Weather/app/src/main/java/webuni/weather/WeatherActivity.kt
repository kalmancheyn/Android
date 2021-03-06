package webuni.weather

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import webuni.weather.data.WeatherForecast
import webuni.weather.data.WeatherResult
import webuni.weather.network.WeatherAPI
import webuni.weather.network.WeatherForecastAPI
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherAPI = retrofit.create(WeatherForecastAPI::class.java)

        val cityName = intent.getStringExtra("cityName")
        findViewById<TextView>(R.id.tvCityName).apply {
            text = cityName.toString()
        }

        val weatherCall = weatherAPI.getForecast(cityName.toString(),3,"f3d694bc3e1d44c1ed5a97bd1120e8fe")

        weatherCall.enqueue(object : Callback<WeatherForecast> {
            override fun onResponse(call: Call<WeatherForecast>, response: Response<WeatherForecast>) {
                val weatherResult = response.body()

                tvCityName.text = cityName.toString()
                tvTemperature.text = "${weatherResult?.list}°"
                tvTemperatureMaxMin.text = "${weatherResult?.main?.temp_max?.toInt()}° / ${weatherResult?.main?.temp_min?.toInt()}°"

                var iconUrl = "https://openweathermap.org/img/w/${weatherResult!!.weather!!.get(0).icon}.png"

                Glide.with(this@WeatherActivity).load(iconUrl).into(ivWeather)

            }

            override fun onFailure(call: Call<WeatherForecast>, t: Throwable) {
                tvCityName.text = t.message
            }

        })

    }
}