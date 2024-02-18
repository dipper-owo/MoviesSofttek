package com.jersson.diaz.moviessofttek.presentation.model


data class MoviesState(
    val listMovies: List<Movie> = listOf(),
    val movieSelected: Movie = Movie(),
) {
    data class Movie(
        val id: Int = 1,
        val posterPath: String = "",
        val title: String = "",
        val voteAverage: Double = 0.0,
        val releaseDate: String = "",
        val synopsis: String = "",
    )

    data class User(
        val user: String = "",
        val password: String = "",
    )
}