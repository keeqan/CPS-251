package com.ebookfrenzy.lifecycleawareproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.lifecycle.LifecycleObserver

class MainActivity : AppCompatActivity(), LifecycleObserver {
    //Variables for DemoOwner and TextView
    private lateinit var demoOwner: DemoOwner
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Text Initialize
        outputTextView = findViewById(R.id.output)
        //DemoOwner with the outputTextView
        demoOwner = DemoOwner(outputTextView)
        // Add DemoOwner as a lifecycle observer
        lifecycle.addObserver(demoOwner)

        if (savedInstanceState != null) {
            // Restore the previous text when on rotation and home screen
            val previousText = savedInstanceState.getString("outputText")
            outputTextView.text = previousText
        }
    }
    // Save the current text when configuration changes
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("outputText", outputTextView.text.toString())
    }
}