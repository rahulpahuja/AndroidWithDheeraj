package com.rp.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    //Public Private property
    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> = _age

    fun getAgeData(): LiveData<Int> {
        return _age
    }

    fun setAgeData(age: Int) {
        _age.value = age
    }

    fun getFlowOfNumbers(max:Int):Flow<Int>{
        var flowOfNumebes:Flow<Int> = flow {
            for (i in 0..<max) {
                emit(i)
            }
        }
        return flowOfNumebes
    }

    suspend fun getNumbers(){
        getFlowOfNumbers(10).collect {value->
            println(value)
        }
    }

}