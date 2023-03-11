package com.example.android_academy

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_academy.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSecondBinding.bind(view)

        viewModel.movies.observe(viewLifecycleOwner) { list ->
            list.forEach {
                val tempTextView = TextView(requireContext())
                tempTextView.text = it.toString()
                tempTextView.textSize = 25f
                binding.constraintLayout03.addView(tempTextView)
            }
        }
    }
}