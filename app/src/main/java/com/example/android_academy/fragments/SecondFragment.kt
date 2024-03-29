package com.example.android_academy.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_academy.R
import com.example.android_academy.adapters.MoviesRecyclerAdapter
import com.example.android_academy.databinding.FragmentSecondBinding
import com.example.android_academy.models.ListViewModel

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSecondBinding.bind(view)

        viewModel.movies.observe(viewLifecycleOwner) { list ->
            binding.rvMovies.adapter = MoviesRecyclerAdapter(requireContext(), list)
        }
    }
}