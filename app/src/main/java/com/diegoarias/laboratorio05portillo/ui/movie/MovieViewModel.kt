package com.diegoarias.laboratorio05portillo.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.diegoarias.laboratorio05portillo.MovieReviewerApplication
import com.diegoarias.laboratorio05portillo.data.models.MovieModel
import com.diegoarias.laboratorio05portillo.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    fun getMovies() = repository.getMovies()
    fun addMovie(movie: MovieModel) = repository.addMovie(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }

}