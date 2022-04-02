package com.nahuel.filmsapp.data.remote

import com.nahuel.filmsapp.data.model.Movie
import com.nahuel.filmsapp.data.model.MovieList

class MovieDataSource {

    fun getUpcomingMovies(): MovieList {
        return MovieList()
    }


    fun getTopRatedMovies(): MovieList {
        return MovieList()
    }

    fun getPopularMovies(): MovieList {
        return MovieList()
    }

}