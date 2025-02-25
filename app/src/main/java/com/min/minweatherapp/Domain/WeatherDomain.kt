package com.min.modulebweather.Domain

import com.min.minweatherapp.Domain.CityDomain

/**
 *Created by ming on 2025/2/25.
 */
data class WeatherDomain(
    val cityData: List<CityDomain>,
    val hourlyData: List<HourlyModel>,
    val futureData: List<FutureDomain>
)
