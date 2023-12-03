
package com.ebookfrenzy.coroutinesproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Hold the Names
    private val _nameList = MutableLiveData<MutableList<String>>(mutableListOf())
    val nameList: LiveData<MutableList<String>> = _nameList

    // Delays With the Names
    private val _delayList = MutableLiveData<MutableList<Long>>(mutableListOf())
    val delayList: LiveData<MutableList<Long>> = _delayList

    // Add Name to List
    fun addName(name: String) {
        // Launch coroutine
        viewModelScope.launch {
            // Generate a delay between 1 to 10 seconds
            val randomDelay = (1..10).random().times(1000).toLong()
            delay(randomDelay) // Suspend the coroutine for the random delay

            // Add the name delay to LiveData lists
            _nameList.value?.add(name)
            _delayList.value?.add(randomDelay)

            // Notify observers
            _nameList.value = _nameList.value
            _delayList.value = _delayList.value
        }
    }
}