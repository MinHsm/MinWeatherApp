package com.min.minweatherapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.min.minweatherapp.Adapter.HourlyAdapter
import com.min.minweatherapp.Adapter.OtherCityAdapter
import com.min.minweatherapp.Domain.CityModel
import com.min.minweatherapp.Domain.HourlyModel
import com.min.minweatherapp.R
import com.min.minweatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chipNavigator.setItemSelected(R.id.home, true)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.chipNavigator.setOnItemSelectedListener { id ->
            when (id) {
                R.id.home -> {
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                }

                R.id.profile -> {
                    startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                }

                R.id.bookmark -> {
                    startActivity(Intent(this@MainActivity, BookMarkActivity::class.java))
                }
            }
        }

        initRecycleviewHourly()
        initRecyclerOtherCity()
    }

    private fun initRecyclerOtherCity() {
        val items: ArrayList<CityModel> = ArrayList()
        items.add(CityModel("中山", 28, "cloudy", 12, 20, 30, "多云"))
        items.add(CityModel("成都", 29, "sunny", 5, 22, 12, "晴"))
        items.add(CityModel("重庆", 30, "windy", 30, 25, 50, "大风"))
        items.add(CityModel("赣州", 31, "cloudy_2", 20, 20, 35, "局部多云"))
        items.add(CityModel("西藏", 10, "snowy", 8, 5, 7, "小雪"))

        binding.view2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = OtherCityAdapter(items) { city ->
            val intent = Intent(this@MainActivity, CityActivity::class.java)
            intent.putExtra("city_name", city.cityName)
            intent.putExtra("city_temperature", city.temp)
            intent.putExtra("city_wind", city.wind)
            intent.putExtra("city_humidity", city.humidity)
            intent.putExtra("city_rain", city.rain)
            intent.putExtra("city_weather", city.weatherQk)
            intent.putExtra("city_pic_path", city.picPath)
            startActivity(intent)
        }

        binding.view2.adapter = adapter
    }

    private fun initRecycleviewHourly() {
        val items: ArrayList<HourlyModel> = ArrayList()
        items.add(HourlyModel("9 pm", 28, "cloudy"))
        items.add(HourlyModel("10 pm", 29, "sunny"))
        items.add(HourlyModel("11 pm", 30, "windy"))
        items.add(HourlyModel("12 pm", 31, "cloudy_2"))
        items.add(HourlyModel("1 am", 10, "snowy"))

        binding.view1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.view1.adapter = HourlyAdapter(items)
    }
}