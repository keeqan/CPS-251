package com.ebookfrenzy.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.namesavedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        binding.textView.text = "No names to display"


        binding.button.setOnClickListener {
            val name = binding.editText.text.toString()
            if (name.isNotEmpty()) {
                viewModel.setName(name)
            }
            else {
                binding.textView.text = "No Names Entered"
            }
        }

        updateNameDisplay()
    }

    private fun updateNameDisplay() {
        viewModel.nameList.observe(this) { names ->
            if (names.isNotEmpty()) {
                binding.textView.text = names.joinToString("\n")
            } else {
                binding.textView.text = "No names to display"
            }
        }
    }
}