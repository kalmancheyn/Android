package webuni.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import webuni.weather.data.WeatherResult
import webuni.weather.network.WeatherAPI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeather.setOnClickListener {
            val startWeather = Intent(this,WeatherActivity::class.java)
            startWeather.putExtra("cityName", etCity.text.toString())
            startActivity(startWeather)
        }
    }
}