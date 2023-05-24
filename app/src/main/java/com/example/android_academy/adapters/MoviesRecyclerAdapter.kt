package com.example.android_academy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.android_academy.R
import com.example.android_academy.databinding.MovieListBinding
import com.example.android_academy.models.Movie

class MoviesRecyclerAdapter(private val context: Context, private val moviesList: ArrayList<Movie>) :
    RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>(){



    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = MovieListBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewHolder = LayoutInflater.from(context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]

        holder.binding.apply {
            rvTitle.text = movie.title
            rvReleaseYear.text = movie.releaseYear.toString()
            rvGenre.text = movie.genre.toString()
            rvRating.text = movie.rating.toString()
            rvImage.load(movie.imageUrl){
               transformations(CircleCropTransformation())
               placeholder(R.drawable.movie_image)
            }
        }

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}