package com.diegoarias.laboratorio05portillo.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.diegoarias.laboratorio05portillo.databinding.FragmentCreateMovieBinding
import com.diegoarias.laboratorio05portillo.ui.movie.viewmodel.MovieViewModel


class CreateMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentCreateMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }


    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", viewModel.getMovies().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(MovieViewModel.WRONG_DATA) -> {
                    Log.d("APP TAG", status)
                }
            }
        }
    }


}