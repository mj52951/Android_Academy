package com.example.android_academy

import android.os.Bundle
import android.view.View
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
        
        binding.btnAdd.setOnClickListener {

            val movie = Movie(
                binding.etTitle.text.toString(),
                binding.etReleaseYear.text.toString().toInt(),
                binding.etRating.text.toString().toInt()
            )

            viewModel.addMovie(movie)

            binding.etTitle.clearText()
            binding.etReleaseYear.clearText()
            binding.etRating.clearText()
        }
    }

    fun EditText.clearText(){
        this.text.clear()
    }
}