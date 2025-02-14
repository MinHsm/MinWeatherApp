package com.min.minweatherapp.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.min.minweatherapp.Adapter.FutureAdapter
import com.min.minweatherapp.Adapter.OtherCityAdapter
import com.min.minweatherapp.Domain.FutureDomain
import com.min.minweatherapp.R
import com.min.minweatherapp.databinding.ActivityCityBinding

class CityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityName = intent.getStringExtra("city_name")
        val cityTemperature = intent.getIntExtra("city_temperature", 0)
        val cityWind = intent.getIntExtra("city_wind", 0)
        val cityHumidity = intent.getIntExtra("city_humidity", 0)
        val cityRain = intent.getIntExtra("city_rain", 0)
        val cityWeather = intent.getStringExtra("city_weather")
        val cityPicPath = intent.getStringExtra("city_pic_path")

        binding.tvCityName.text = cityName
        binding.cityTempTxt.text = "$cityTemperature°C"
        binding.tvCityWeather.text = cityWeather
        binding.cityRainTxt.text = "$cityRain%"
        binding.cityWindTxt.text = "$cityWind km/h"
        binding.cityHumidityTxt.text = "$cityHumidity%"

        val drawableResourceId = resources.getIdentifier(
            cityPicPath, "drawable", packageName
        )

        Glide.with(this)
            .load(drawableResourceId)
            .into(binding.cityPic)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        initRecycleViewWeek()
    }

    private fun initRecycleViewWeek() {
        val items: ArrayList<FutureDomain> = ArrayList()
        items.add(FutureDomain("星期一", "storm", "大雪", 24, 12))
        items.add(FutureDomain("星期二", "cloudy", "多云", 24, 12))
        items.add(FutureDomain("星期三", "windy", "多云", 24, 12))
        items.add(FutureDomain("星期四", "cloudy_sunny", "局部多云", 24, 12))
        items.add(FutureDomain("星期五", "sunny", "晴", 24, 12))
        items.add(FutureDomain("星期六", "rainy", "小雨", 24, 12))

        binding.viewWeek.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.viewWeek.adapter = FutureAdapter(items)
    }
}