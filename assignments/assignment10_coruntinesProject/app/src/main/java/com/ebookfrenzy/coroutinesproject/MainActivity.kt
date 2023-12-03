package com.ebookfrenzy.coroutinesproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import com.ebookfrenzy.coroutinesproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Setup RecyclerView and observe ViewModel
        setupRecyclerView()
        observeViewModel()
    }

    // Set up the RecyclerView
    private fun setupRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter()
        binding.myRecyclerView.adapter = adapter
    }

    // Observe ViewModel
    private fun observeViewModel() {
        mainViewModel.nameList.observe(this) { nameList ->
            // Update the RecyclerView adapter
            adapter?.updateData(nameList, mainViewModel.delayList.value ?: mutableListOf())
        }
    }

    // Coroutine is launched
    fun launchCoroutine(view: View) {
        // Pull Name
        val name = binding.addNameText.text.toString()

        //Check If name is empty
        if(name.isBlank()){
            return
        }

        // Clear Text
        binding.addNameText.text.clear()
        // Add Name
        mainViewModel.addName(name)
    }
}
