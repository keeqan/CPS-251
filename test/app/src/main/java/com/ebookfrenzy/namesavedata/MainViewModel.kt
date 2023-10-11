package com.ebookfrenzy.namesavedata

import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel(){

    private val nameList = mutableListOf<String>()


    fun setName(value: String){
        nameList.add(value)
    }

    fun getName(): List<String> {
        return nameList.toList()
    }







}