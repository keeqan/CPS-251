package com.ebookfrenzy.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.namesavedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //creates the links to binding and to the main view model

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    //creates a blank variable for updating the text

    private val updateText = ""


    //on create function

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //calls the update name function bringing it to the display
        updateNameDisplay()


        binding.button.setOnClickListener{//checks for button click
            // checks if the text is empty, if not adds it to the list
            if (binding.editText.text.isNotEmpty()) {
                viewModel.setName(binding.editText.text.toString())
                binding.textView.text = viewModel.getName().joinToString( "\n")

            } else { // if there is no name
                binding.textView.text = "No Name Entered"
            }

        }

    }
        //creates the save on instance
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(updateText, binding.textView.text.toString())
    }
        //restores the save
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedText = savedInstanceState.getString(updateText)
        binding.textView.text = savedText
    }
        //function that updates the name / and checks if text view is empty
    private fun updateNameDisplay(){
        val nameList = viewModel.getName()
        if (nameList.isNotEmpty()){
            binding.textView.text = nameList.joinToString { "\n" }
        } else {
            binding.textView.text = "No names to display"
        }
    }


}