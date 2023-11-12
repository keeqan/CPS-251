package com.ebookfrenzy.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.recycleview.databinding.CardLayoutBinding


class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
          //Binds data to the views in the ViewHolder.
        fun bind(position: Int) {
            // Set the data to the views from the ViewModel
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