package com.diegoarias.laboratorio05portillo.repository

import com.diegoarias.laboratorio05portillo.data.models.MovieModel

class MovieRepository(private val movies:MutableList<MovieModel>) {
    fun getMovies() = movies

    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)
}