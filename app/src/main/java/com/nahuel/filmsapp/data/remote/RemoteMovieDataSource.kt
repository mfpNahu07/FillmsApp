package com.nahuel.filmsapp.data.remote

import com.nahuel.filmsapp.aplicattion.AppConstants
import com.nahuel.filmsapp.data.model.Movie
import com.nahuel.filmsapp.data.model.MovieList
import com.nahuel.filmsapp.repository.WebService

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList =
        webService.getUpcomingMovies(AppConstants.API_KEY)


    suspend fun getTopRatedMovies(): MovieList =
        webService.getTopRatedMovies(AppConstants.API_KEY)


    suspend fun getPopularMovies(): MovieList =
        webService.getPopularMovies(AppConstants.API_KEY)


}