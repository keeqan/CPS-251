package com.ebookfrenzy.recycleviewwithintents

import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent

import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.recycleviewwithintents.databinding.CardLayoutBinding


class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                // Get the context
                val context = it.context

                // Create an intent for the SecondActivity
                val intent = Intent(context, SecondActivity::class.java).apply {
                    // Pass data to the SecondActivity
                    putExtra("TITLE", viewModel.titles[adapterPosition])
                    putExtra("DETAILS", viewModel.details[adapterPosition])
                    putExtra("IMAGE_ID", viewModel.images[adapterPosition])
                }

                // Start the activity
                context.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.itemTitle.text = viewModel.titles[position]
            binding.itemDetail.text = viewModel.details[position]
            binding.itemImage.setImageResource(viewModel.images[position])
        }
    }

    // RecyclerView needs a new ViewHolder.
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        // Inflate the layout for the item
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // display the data
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // Bind the data to the ViewHolder
        viewHolder.bind(i)
    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        //  size of the titles array as the item count
        return viewModel.titles.size
    }
}