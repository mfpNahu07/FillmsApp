package com.nahuel.filmsapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.nahuel.filmsapp.R
import com.nahuel.filmsapp.core.Resource
import com.nahuel.filmsapp.data.model.Movie
import com.nahuel.filmsapp.data.remote.RemoteMovieDataSource
import com.nahuel.filmsapp.databinding.FragmentMovieBinding
import com.nahuel.filmsapp.presentation.MovieViewModel
import com.nahuel.filmsapp.presentation.MovieViewModelFactory
import com.nahuel.filmsapp.repository.MovieRepositoryImpl
import com.nahuel.filmsapp.repository.RetrofitClient
import com.nahuel.filmsapp.ui.movie.adapters.MovieAdapter
import com.nahuel.filmsapp.ui.movie.adapters.concat.PopularConcatAdapter
import com.nahuel.filmsapp.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.nahuel.filmsapp.ui.movie.adapters.concat.UpcomingConcatAdapter


class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {


    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImpl(
                RemoteMovieDataSource(RetrofitClient.webservice)
            )
        )
    }

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData", " Loading...")
                }

                is Resource.Success -> {
                   // binding.rvMovies.adapter = concatAdapter
                    Log.d(
                        "LiveData",
                        " Upcoming:${result.data.first} \n TopRated:${result.data.second} \n Popular:${result.data.third}")
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                                            addAdapter(0, UpcomingConcatAdapter(MovieAdapter(result.data.first.results, this@MovieFragment)))
                                            addAdapter(1, TopRatedConcatAdapter(MovieAdapter(result.data.second.results, this@MovieFragment)))
                                            addAdapter(2, PopularConcatAdapter(MovieAdapter(result.data.third.results, this@MovieFragment)))
                    }

                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                    binding.progressBar.visibility = View.GONE
                }
            }
        })


    }

    override fun onMovieClick(movie: Movie) {
        Log.d("Movie", "onMovieClick:$movie")
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(movie.poster_path,
            movie.backdrop_path,
            movie.vote_average.toFloat(),
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date)
        findNavController().navigate(action)
    }

}