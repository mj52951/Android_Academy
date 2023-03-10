package com.example.android_academy

data class Movie(val title: String, val releaseYear: Int, val rating: Int) {

    override fun toString(): String {
        return "$title $releaseYear $rating"
    }
}