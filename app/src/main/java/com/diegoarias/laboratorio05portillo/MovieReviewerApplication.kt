package com.diegoarias.laboratorio05portillo

import android.app.Application
import com.diegoarias.laboratorio05portillo.data.movies
import com.diegoarias.laboratorio05portillo.repository.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}