package com.ebookfrenzy.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.namesavedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val updateText = ""



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        updateNameDisplay()

        binding.button.setOnClickListener{

            if (binding.editText.text.isNotEmpty()) {
                viewModel.setName(binding.editText.text.toString())
                binding.textView.text = viewModel.getName().joinToString( "\n")

            } else {
                binding.textView.text = "No Name Entered"
            }

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(updateText, binding.textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedText = savedInstanceState.getString(updateText)
        binding.textView.text = savedText
    }

    private fun updateNameDisplay(){
        val nameList = viewModel.getName()
        if (nameList.isNotEmpty()){
            binding.textView.text = nameList.joinToString { "\n" }
        } else {
            binding.textView.text = "No names to display"
        }
    }


}