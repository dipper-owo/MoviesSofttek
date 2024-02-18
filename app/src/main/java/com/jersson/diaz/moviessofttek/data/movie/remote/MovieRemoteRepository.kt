package com.jersson.diaz.moviessofttek.data.movie.remote

import com.jersson.diaz.moviessofttek.data.movie.remote.model.mapper.toListMovie
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.data.movie.remote.network.MovieService
import javax.inject.Inject

class MovieRemoteRepository @Inject constructor(
    private val api: MovieService
) {
    suspend fun getListMovies(): List<MoviesState.Movie>? {
        val response = api.getListMovies()
        return response?.listMovies?.toListMovie()
    }
}