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

        binding.tvCk.setOnClickListener {
            val intent = Intent(this@MainActivity, CityActivity::class.java)
            startActivity(intent)
        }

        initRecycleviewHourly()
        initRecyclerOtherCity()
    }

    private fun initRecyclerOtherCity() {
        val items: ArrayList<CityModel> = ArrayList()
        items.add(CityModel("中山", 28, "cloudy", 12, 20, 30))
        items.add(CityModel("成都", 29, "sunny", 5, 22, 12))
        items.add(CityModel("重庆", 30, "windy", 30, 25, 50))
        items.add(CityModel("赣州", 31, "cloudy_2", 20, 20, 35))
        items.add(CityModel("西藏", 10, "snowy", 8, 5, 7))

        binding.view2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.view2.adapter = OtherCityAdapter(items)
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