package webuni.weather

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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherAPI = retrofit.create(WeatherAPI::class.java)

        btnWeather.setOnClickListener {
            val weatherCall = weatherAPI.getPlace(etCity.toString())

            weatherCall.enqueue(object : Callback<WeatherResult> {
                override fun onResponse(
                    call: Call<WeatherResult>,
                    response: Response<WeatherResult>
                ) {
                    val weatherResult = response.body()

                    tvResult.text = "Hőmérséklet: ${weatherResult?.sys?.country}"
                }

                override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                    tvResult.text = t.message
                }

            })
        }
    }
}