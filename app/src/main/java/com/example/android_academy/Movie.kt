package com.example.android_academy

data class Movie(val title: String, val releaseYear: Int, val rating: Int, val genre: Genre) {

    override fun toString(): String {
        return "$title\n $genre\n $releaseYear\n Rating: $rating\n"
    }
}