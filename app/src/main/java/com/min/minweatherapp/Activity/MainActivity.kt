package com.min.minweatherapp.Activity

import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.min.minweatherapp.Activity.BookMarkActivity
import com.min.minweatherapp.Activity.ProfileActivity
import com.min.minweatherapp.Domain.CityDomain
import com.min.minweatherapp.R
import com.min.minweatherapp.databinding.ActivityMainBinding
import com.min.modulebweather.Adapter.CardCityAdapter
import com.min.modulebweather.Adapter.HourlyAdapter
import com.min.modulebweather.Domain.HourlyModel
import com.min.modulebweather.Domain.WeatherDomain
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherDataJson = loadJsonFromAsset(this, "weather_data.json")
        val weatherData = parseWeatherData(weatherDataJson)
        val cityData = weatherData.cityData
        val hourlyData = weatherData.hourlyData

        binding.chipNavigator.setItemSelected(R.id.home, true)

        binding.chipNavigator.setOnItemSelectedListener { id ->
            when (id) {
                R.id.home -> {
                    startActivity(Intent(this@MainActivity, CityActivity::class.java))
                }

                R.id.bookmark -> {
                    startActivity(Intent(this@MainActivity, BookMarkActivity::class.java))
                }

                R.id.profile -> {
                    startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                }
            }

        }

        initHourly(hourlyData)
        initCardCity(cityData)

    }

    private fun loadJsonFromAsset(context: Context, fileName: String): String {
        val assetManager: AssetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val reader = InputStreamReader(inputStream)
        return reader.readText()
    }

    private fun parseWeatherData(jsonData: String): WeatherDomain {
        val gson = Gson()
        val type = object : TypeToken<WeatherDomain>() {}.type
        return gson.fromJson(jsonData, type)
    }

    private fun initCardCity(items: List<CityDomain>) {

        val cityList = ArrayList(items)

        binding.view2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = CardCityAdapter(cityList) { city ->
            val intent = Intent(this@MainActivity, CityActivity::class.java)
            intent.putExtra("ct_name", city.cityName)
            intent.putExtra("ct_temp", city.temp)
            intent.putExtra("ct_pic", city.picPath)
            intent.putExtra("ct_wind", city.wind)
            intent.putExtra("ct_humidity", city.humidity)
            intent.putExtra("ct_rain", city.rain)
            intent.putExtra("ct_wqk", city.weatherQk)

            startActivity(intent)
        }

        binding.view2.adapter = adapter

    }

    private fun initHourly(items: List<HourlyModel>) {

        val hourlyList = ArrayList(items)

        binding.view1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.view1.adapter = HourlyAdapter(hourlyList)
    }
}