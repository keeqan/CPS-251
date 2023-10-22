package com.ebookfrenzy.namesavedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MainViewModel : ViewModel() {
    private val _nameList = MutableLiveData<List<String>>()
    val nameList: LiveData<List<String>> get() = _nameList

    fun setName(value: String) {
        val currentList = _nameList.value.orEmpty().toMutableList()
        currentList.add(value)
        _nameList.value = currentList
    }

    fun getNames(): List<String> {
        return _nameList.value.orEmpty()
    }
}