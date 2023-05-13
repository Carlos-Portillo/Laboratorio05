package com.diegoarias.laboratorio05portillo.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.diegoarias.laboratorio05portillo.data.models.MovieModel
import com.diegoarias.laboratorio05portillo.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }

}