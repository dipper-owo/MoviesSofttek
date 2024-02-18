package com.jersson.diaz.moviessofttek.domain.repository

import com.jersson.diaz.moviessofttek.presentation.model.MoviesState

interface IMovieRepository {
    suspend fun getListMovie(): List<MoviesState.Movie>
    suspend fun deleteAllMovies()
    suspend fun insertMovies(movie: MoviesState.Movie)
}