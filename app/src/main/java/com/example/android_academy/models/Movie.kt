package com.example.android_academy.models


data class Movie(val title: String, val releaseYear: Int, val rating: Int, val genre: Genre, val imageUrl: String) {

    override fun toString(): String {
        return "$title\n $genre\n $releaseYear\n Rating: $rating\n"
    }



}