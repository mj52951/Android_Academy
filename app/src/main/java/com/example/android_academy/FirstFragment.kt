package com.example.android_academy

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_academy.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, Genre.values())
        binding.spGenre.adapter = adapter

        var selectedGenre: Genre = Genre.Comedy

        binding.spGenre.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedGenre = p0?.getItemAtPosition(p2) as Genre
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                selectedGenre = Genre.Comedy
            }
        }

        binding.btnAdd.setOnClickListener {

            val movie = Movie(
                binding.etTitle.text.toString(),
                binding.etReleaseYear.text.toString().toInt(),
                binding.etRating.text.toString().toInt(),
                selectedGenre
            )

            viewModel.addMovie(movie)

            binding.etTitle.clearText()
            binding.etReleaseYear.clearText()
            binding.etRating.clearText()
        }
    }

    private fun EditText.clearText(){
        this.text.clear()
    }
}