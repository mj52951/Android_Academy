package com.example.android_academy.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_academy.R
import com.example.android_academy.databinding.FragmentFirstBinding
import com.example.android_academy.models.Genre
import com.example.android_academy.models.ListViewModel
import com.example.android_academy.models.Movie

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        val adapter = ArrayAdapter(requireContext(), R.layout.spinner, Genre.values())
        binding.spGenre.adapter = adapter

        var selectedGenre: Genre = Genre.Comedy

        binding.spGenre.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedGenre = p0?.getItemAtPosition(p2) as Genre
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                selectedGenre = Genre.Comedy
            }
        }

        binding.btnAdd.setOnClickListener {
            val checkedRadioButton = binding.rgRating.checkedRadioButtonId
            var rating = 1

            when (checkedRadioButton) {
                binding.r1.id -> rating = 1
                binding.r2.id -> rating = 2
                binding.r3.id -> rating = 3
                binding.r4.id -> rating = 4
                binding.r5.id -> rating = 5
            }

            if (binding.etTitle.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    R.string.errorTitle,
                    Toast.LENGTH_LONG
                ).show()
            } else if (binding.etReleaseYear.text.isEmpty() ||
                binding.etReleaseYear.text.toString().toInt() !in 1900..2023
            ) {
                Toast.makeText(
                    requireContext(),
                    R.string.errorYear,
                    Toast.LENGTH_LONG
                ).show()
            } else if (checkedRadioButton == -1) {
                Toast.makeText(
                    requireContext(),
                    R.string.errorRating,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val movie = Movie(
                    binding.etTitle.text.toString(),
                    binding.etReleaseYear.text.toString().toInt(),
                    rating,
                    selectedGenre,
                    ""
                )

                viewModel.addMovie(movie)
                binding.etTitle.clearText()
                binding.etReleaseYear.clearText()
            }
        }
    }

    private fun EditText.clearText() {
        this.text.clear()
    }
}