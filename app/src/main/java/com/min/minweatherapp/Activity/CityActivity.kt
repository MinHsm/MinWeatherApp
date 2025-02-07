package com.min.minweatherapp.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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