package com.ebookfrenzy.navigationproject

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebookfrenzy.navigationproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // The system calls this to draw the fragment's UI for the first time
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

     // Called when the fragment is started
    override fun onStart() {
        super.onStart()
        arguments?.let {
            // Retrieve and display the arguments
            val args = SecondFragmentArgs.fromBundle(it)
            // Set the text for the image title.
            binding.imageTitle.text = args.title
            // Set the image resource for the imageView.
            binding.imageView.setImageResource(args.image)
        }
    }

    //  fragment removed.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}