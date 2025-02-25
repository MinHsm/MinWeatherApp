package com.min.modulebweather.Domain

/**
 *Created by ming on 2025/2/24.
 */
data class FutureDomain(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)
