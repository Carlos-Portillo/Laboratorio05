package com.diegoarias.laboratorio05portillo.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegoarias.laboratorio05portillo.data.models.MovieModel
import com.diegoarias.laboratorio05portillo.data.movies
import com.diegoarias.laboratorio05portillo.databinding.MovieItemBinding

class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movieList: List<MovieModel>) {
        movies.clear()
        movies.addAll(movieList)
    }

}