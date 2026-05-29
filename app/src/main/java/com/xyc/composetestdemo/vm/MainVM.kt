package com.xyc.composetestdemo.vm

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {
    var _count = MutableLiveData<Int>()
    var _doubleCount = MutableLiveData<Int>()

    val count: LiveData<Int> = _count
    val doubleCount: LiveData<Int> = _doubleCount

    fun incrementCount() {
        _count.value = (_count.value ?: 0).plus(1)
    }

    fun incrementDoubleCount() {
        _doubleCount.value = (_doubleCount.value ?: 0).plus(2)
    }
}