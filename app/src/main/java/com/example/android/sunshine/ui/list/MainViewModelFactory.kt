package com.example.android.sunshine.ui.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.android.sunshine.data.SunshineRepository
import com.example.android.sunshine.ui.detail.DetailActivityViewModel
import java.util.Date

class MainViewModelFactory(private val repository: SunshineRepository): ViewModelProvider.NewInstanceFactory() {

    private var mRepository: SunshineRepository? = null

    init {
        mRepository = repository
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainActivityViewModel(repository) as T
    }
}
