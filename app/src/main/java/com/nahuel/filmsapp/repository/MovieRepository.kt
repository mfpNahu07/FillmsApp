package com.nahuel.filmsapp.repository

import com.nahuel.filmsapp.data.model.MovieList

interface MovieRepository {

    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}

/**
 *
 * suspend : usamos coroutinas, la funcion en si no termina hasta traer la informacion del servidor,
 * una vez que se trae la informacion o se devuelve un resultado, la función continúa. Asi no se
 * bloquea el thread subyacente
 *
 *
 *
 * */