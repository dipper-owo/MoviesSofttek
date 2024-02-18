package com.jersson.diaz.moviessofttek.data.movie.local

import com.jersson.diaz.moviessofttek.data.movie.local.datasource.MovieDatabaseDataSource
import com.jersson.diaz.moviessofttek.domain.repository.IMovieRepository
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.data.movie.local.model.mapper.toDbMovie
import com.jersson.diaz.moviessofttek.data.movie.local.model.mapper.toListMovie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDatabaseDataSource: MovieDatabaseDataSource
): IMovieRepository {

    override suspend fun getListMovie(): List<MoviesState.Movie> {
        return movieDatabaseDataSource.getListDbMovie().toListMovie()
    }

    override suspend fun deleteAllMovies() {
        movieDatabaseDataSource.deleteAllMovies()
    }

    override suspend fun insertMovies(movie: MoviesState.Movie) {
        movieDatabaseDataSource.insertMovies(movie.toDbMovie())
    }
}