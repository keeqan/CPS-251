package com.ebookfrenzy.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.namesavedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.textView.text = viewModel.getName().toString()


        binding.button.setOnClickListener{
            if (binding.editText.text.isNotEmpty()) {
                viewModel.setName(binding.editText.text.toString())
                binding.textView.text = viewModel.getName().joinToString( "\n")
            } else {
                binding.textView.text = "No Name Entered"
            }




        }






    }
}