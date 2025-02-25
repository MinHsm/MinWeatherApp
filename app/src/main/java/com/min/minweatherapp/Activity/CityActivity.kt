package com.min.minweatherapp.Activity

import android.content.Context
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.min.minweatherapp.databinding.ActivityCityBinding
import com.min.modulebweather.Adapter.FutureAdapter
import com.min.modulebweather.Domain.FutureDomain
import com.min.modulebweather.Domain.WeatherDomain
import java.io.InputStreamReader

class CityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherDataJson = JsonFromWeather(this, "weather_data.json")
        val weatherData = parseWeatherData(weatherDataJson)
        val futureData = weatherData.futureData

        val ctName = intent.getStringExtra("ct_name")
        val ctTemp = intent.getIntExtra("ct_temp", 0)
        val ctPic = intent.getStringExtra("ct_pic")
        val ctWind = intent.getIntExtra("ct_wind", 0)
        val ctHumidity = intent.getIntExtra("ct_humidity", 0)
        val ctRain = intent.getIntExtra("ct_rain", 0)
        val ctWqk = intent.getStringExtra("ct_wqk")

        binding.ctBack.setOnClickListener {
            onBackPressed()
        }

        val drawableResourceId = resources.getIdentifier(
            ctPic,
            "drawable",
            packageName
        )

        Glide.with(this)
            .load(drawableResourceId)
            .into(binding.ctCardImg)

        binding.ctMainTitle.text = ctName
        binding.ctCardJy.text = "$ctRain%"
        binding.ctCardFs.text = "$ctWind" + "Km/h"
        binding.ctCardQk.text = ctWqk
        binding.ctCardSd.text = "$ctHumidity%"
        binding.ctCardWd.text = "$ctTemp" + "˚C"

        initFutureRc(futureData)

    }

    private fun initFutureRc(items: List<FutureDomain>) {
        val futureList = ArrayList(items)

        binding.ctRecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.ctRecycle.adapter = FutureAdapter(futureList)

    }

    private fun JsonFromWeather(context: Context, fileName: String): String {
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
}