package com.nahuel.filmsapp.repository

import com.nahuel.filmsapp.data.model.MovieList
import com.nahuel.filmsapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource) : MovieRepository {


    override suspend fun getUpcomingMovies(): MovieList = dataSourceRemote.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSourceRemote.getPopularMovies()

}


/**
 * ctrl + i para implementar
 *
 * */