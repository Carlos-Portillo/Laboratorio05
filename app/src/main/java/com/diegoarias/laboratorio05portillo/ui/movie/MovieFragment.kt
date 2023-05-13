package com.diegoarias.laboratorio05portillo.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.diegoarias.laboratorio05portillo.R
import com.diegoarias.laboratorio05portillo.databinding.FragmentMovieBinding
import com.diegoarias.laboratorio05portillo.ui.movie.viewmodel.MovieViewModel


class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

}