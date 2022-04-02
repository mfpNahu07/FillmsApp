package com.nahuel.filmsapp.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.nahuel.filmsapp.R
import com.nahuel.filmsapp.databinding.FragmentMovieBinding


class MovieFragment : Fragment(R.layout.fragment_movie) {


    private lateinit var binding : FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

    }

}