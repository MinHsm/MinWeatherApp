package com.min.minweatherapp.Domain

/**
 *Created by ming on 2025/1/9.
 */
data class CityDomain(
    val cityName: String,
    val temp: Int,
    val picPath: String,
    val wind: Int,
    val humidity: Int,
    val rain: Int,
    val weatherQk: String
)
