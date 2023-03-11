package com.example.android_academy

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
            binding.lvMovies.adapter = adapter
        }
    }


}