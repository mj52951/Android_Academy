package com.example.android_academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FirstFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAdd: Button = view.findViewById(R.id.btn_add)

        btnAdd.setOnClickListener {
            val movieTitle: EditText = view.findViewById(R.id.et_title)
            val movieYear: EditText = view.findViewById(R.id.et_release_year)
            val movieRating: EditText = view.findViewById(R.id.et_rating)

            val movie = Movie(
                movieTitle.text.toString(),
                movieYear.text.toString().toInt(),
                movieRating.text.toString().toInt()
            )

            viewModel.addMovie(movie)

            movieTitle.text.clear()
            movieYear.text.clear()
            movieRating.text.clear()
        }
    }
}