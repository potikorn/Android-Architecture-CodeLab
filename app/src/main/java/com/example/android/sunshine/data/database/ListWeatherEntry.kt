package com.example.android.sunshine.data.database

import java.util.Date

data class ListWeatherEntry(
    var id: Int,
    var weatherIconId: Int,
    var date: Date,
    var min: Double,
    var max: Double
)