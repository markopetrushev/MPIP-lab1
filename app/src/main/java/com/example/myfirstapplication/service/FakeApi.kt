package com.example.myfirstapplication.service

import com.example.myfirstapplication.model.MovieCs

class FakeApi {

    private val movies: MutableList<MovieCs>  = mutableListOf(
        MovieCs(1, "title 1", "desc 1", "director 1", mutableListOf("actor 1", "actor 2")),
        MovieCs(2, "title 2", "desc 2", "director 2", mutableListOf("actor 3", "actor 4")),
        MovieCs(3, "title 3", "desc 3", "director 3", mutableListOf("actor 5", "actor 6")),
        MovieCs(4, "title 4", "desc 4", "director 4", mutableListOf("actor 7", "actor 8")),
        MovieCs(5, "title 5", "desc 5", "director 5", mutableListOf("actor 9", "actor 10")),
        MovieCs(6, "title 6", "desc 6", "director 6", mutableListOf("actor 11", "actor 12"))
    )

    fun getAllMovies(): MutableList<MovieCs> {
        return movies;
    }

    fun addMovie(movie: MovieCs) : MutableList<MovieCs> {
        movies.add(movie)
        return movies
    }

}