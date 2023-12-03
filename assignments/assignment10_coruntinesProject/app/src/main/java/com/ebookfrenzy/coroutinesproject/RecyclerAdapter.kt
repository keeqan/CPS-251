package com.ebookfrenzy.coroutinesproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.coroutinesproject.databinding.CardLayoutBinding
class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var names: MutableList<String> = mutableListOf()
    private var delays: MutableList<Long> = mutableListOf()

    // Update the adapter data then refresh the RecyclerView
    fun updateData(newNames: MutableList<String>, newDelays: MutableList<Long>) {
        names = newNames // Update names list
        delays = newDelays // Update delays list
        notifyDataSetChanged() // Notify adapter
    }

    // Items ViewHolder
    inner class ViewHolder(private val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        // Function to bind data
        fun bind(name: String, delay: Long) {
            // Set the text
            binding.displayText.text = "The name is $name and the delay was $delay milliseconds."
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        // Inflate the layout for each item
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = CardLayoutBinding.inflate(inflater, viewGroup, false)
        // Return a new ViewHolder instance
        return ViewHolder(binding)
    }

    // Override function to bind data to each ViewHolder
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // Get the name and delay
        val name = names[i]
        val delay = delays[i]
        // Bind the data
        viewHolder.bind(name, delay)
    }

    // Get the total count of items
    override fun getItemCount(): Int {
        return names.size
    }
}