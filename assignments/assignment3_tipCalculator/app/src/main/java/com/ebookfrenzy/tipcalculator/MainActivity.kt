package com.ebookfrenzy.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //calls the tip calc function on press

        binding.tipBtn.setOnClickListener(){
            tipCalc()
        }


    }
    private fun tipCalc(){
        if (binding.billAmount.text.isNotEmpty()){

            //changes bill amount to a float

            val billAmount = binding.billAmount.text.toString().toFloat()

            //calculates the percentage

            val tenPer = billAmount * 0.1
            val fifPer = billAmount * 0.15
            val twenPer = billAmount * 0.2

            //outputs the tip amounts

            binding.output.text  = (

                    "The tips are as follows: \n" +
                    "10% = " + (tenPer + billAmount) +"\n" +
                    "15% = " + (fifPer+ billAmount) + "\n" +
                    "20% = " + (twenPer+ billAmount)
                    )
        }

        else {
            binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }




}