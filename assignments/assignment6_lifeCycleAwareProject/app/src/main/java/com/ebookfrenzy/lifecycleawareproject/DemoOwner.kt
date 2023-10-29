package com.ebookfrenzy.lifecycleawareproject

import android.widget.TextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.text.SimpleDateFormat
import java.util.*
//Defines DemoOwner
class DemoOwner(private val outputTextView: TextView) : DefaultLifecycleObserver {
    //override functions
    override fun onCreate(owner: LifecycleOwner) {
        updateTextView("onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        updateTextView("onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        updateTextView("onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        updateTextView("onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        updateTextView("onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        updateTextView("onDestroy")
    }
        //Updates the TextView with current time + lifecycle events function
    private fun updateTextView(event: String) {
        val currentTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
        val date = Date(currentTime)
        val formattedDate = dateFormat.format(date)

        val text = "${outputTextView.text}\n$event was fired on $formattedDate"
        outputTextView.text = text
        if (event == "onResume" || event == "onPause" || event == "onDestroy") {
            addLine()
        }
    }
        //Adds separator
    private fun addLine(){
        val text = "${outputTextView.text}\n**************"
        outputTextView.text = text
    }
}