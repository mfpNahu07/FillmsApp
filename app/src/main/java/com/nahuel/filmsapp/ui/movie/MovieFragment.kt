package com.nahuel.filmsapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nahuel.filmsapp.R
import com.nahuel.filmsapp.core.Resource
import com.nahuel.filmsapp.data.remote.MovieDataSource
import com.nahuel.filmsapp.databinding.FragmentMovieBinding
import com.nahuel.filmsapp.presentation.MovieViewModel
import com.nahuel.filmsapp.presentation.MovieViewModelFactory
import com.nahuel.filmsapp.repository.MovieRepositoryImpl
import com.nahuel.filmsapp.repository.RetrofitClient


class MovieFragment : Fragment(R.layout.fragment_movie) {


    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImpl(
                MovieDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("LiveData"," Loading...")
                }

                is Resource.Success -> {
                    Log.d("LiveData"," Upcoming:${result.data.first} \n TopRated:${result.data.second} \n Popular:${result.data.third}")
                }
                is Resource.Failure -> {
                    Log.d("Error","${result.exception}")
                }
            }
        })


    }

}