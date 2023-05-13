package com.diegoarias.laboratorio05portillo.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoarias.laboratorio05portillo.R
import com.diegoarias.laboratorio05portillo.data.models.MovieModel
import com.diegoarias.laboratorio05portillo.databinding.FragmentBillboardBinding
import com.diegoarias.laboratorio05portillo.ui.movie.viewmodel.MovieViewModel
import com.diegoarias.laboratorio05portillo.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter


class BillboardFragment : Fragment() {

    private val moviewViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentBillboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            moviewViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel) {
        moviewViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovies() {
        adapter.setData(moviewViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.RecyclerView.adapter = adapter
        displayMovies()
    }

}