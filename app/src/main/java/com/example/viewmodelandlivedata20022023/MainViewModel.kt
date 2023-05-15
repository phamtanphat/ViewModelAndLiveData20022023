package com.example.viewmodelandlivedata20022023

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

/**
 * Created by pphat on 5/15/2023.
 */
class MainViewModel: ViewModel() {
    private var mutableLiveDataNumber: MutableLiveData<Int> = MutableLiveData()

    fun getNumberLiveData() = mutableLiveDataNumber

    fun randomNumber() {
        mutableLiveDataNumber.value = Random.nextInt(100)
    }
}
