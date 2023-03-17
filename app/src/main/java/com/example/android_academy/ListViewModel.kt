package com.example.android_academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private var _movies: MutableLiveData<ArrayList<Movie>> = MutableLiveData(arrayListOf())
    val movies: LiveData<ArrayList<Movie>>
        get() = _movies

    fun addMovie(movie: Movie) {
        val tempData = _movies.value
        tempData?.add(movie)
        _movies.value = tempData!!
    }
}