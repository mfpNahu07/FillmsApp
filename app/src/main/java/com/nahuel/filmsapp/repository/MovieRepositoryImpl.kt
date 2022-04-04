package com.nahuel.filmsapp.repository

import com.nahuel.filmsapp.data.model.MovieList
import com.nahuel.filmsapp.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {


    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

}


/**
 * ctrl + i para implementar
 *
 * */