package com.rp.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Public Private property
    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> get() = _age

    fun getAgeData(): LiveData<Int> {
        return _age
    }

    fun setAgeData(age: Int) {
        _age.value = age
    }
}