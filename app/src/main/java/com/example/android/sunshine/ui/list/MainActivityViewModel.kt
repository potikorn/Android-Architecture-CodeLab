package com.example.android.sunshine.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.android.sunshine.data.SunshineRepository
import com.example.android.sunshine.data.database.ListWeatherEntry

class MainActivityViewModel(repository: SunshineRepository) : ViewModel() {

    private var mWeatherList: LiveData<MutableList<ListWeatherEntry>>? = null

    init {
        mWeatherList = repository.currentWeatherForecasts
    }

    fun getAllWeatherFromToday(): LiveData<MutableList<ListWeatherEntry>>? {
        return mWeatherList
    }
}