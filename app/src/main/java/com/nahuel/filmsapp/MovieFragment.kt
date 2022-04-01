package com.nahuel.filmsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nahuel.filmsapp.databinding.FragmentMovieBinding


class MovieFragment : Fragment(R.layout.fragment_movie) {


    private lateinit var binding : FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

    }

}