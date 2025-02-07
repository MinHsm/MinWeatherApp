package com.min.minweatherapp.Domain

/**
 * Created by Min on 2025/1/17.
 */
data class FutureDomain(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)
