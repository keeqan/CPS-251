package com.ebookfrenzy.recycleviewwithintents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.recycleviewwithintents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the data from the intent
        val title = intent.getStringExtra("TITLE")
        val details = intent.getStringExtra("DETAILS")
        val imageId = intent.getIntExtra("IMAGE_ID", 0)

        // Set the data to the views
        binding.titleTextViews.text = title
        binding.detailsTextView.text = details
        binding.imageView.setImageResource(imageId)
    }
}