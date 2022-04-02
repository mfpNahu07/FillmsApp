package com.nahuel.filmsapp.data.model

//Clase con los atributos que vienen desde la API.
data class Movie(val adult: Boolean = false,
                 val backdrop_path: String = "",
                 val genre_ids: List<Int> = listOf(),
                 val id: Int = -1,
                 val original_language: String = "",
                 val original_title: String = "",
                 val overview: String = "",
                 val popularity: Double = -1.0,
                 val poster_path: String = "",
                 val release_date: String = "",
                 val title: String = "",
                 val video: Boolean = false,
                 val vote_average: Double = -1.0,
                 val vote_count: Int = -1
)

//Clase que contiene una lista con los objetos que vienen desde la API, cuyo atributo
// se llama igual que el array de objetos que tiene los resultados en la API.
data class MovieList(val results: List<Movie> = listOf())
