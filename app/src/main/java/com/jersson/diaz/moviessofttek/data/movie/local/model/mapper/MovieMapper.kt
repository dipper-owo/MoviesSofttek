package com.jersson.diaz.moviessofttek.data.movie.local.model.mapper

import com.jersson.diaz.moviessofttek.data.movie.local.model.DbMovie
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState

fun List<DbMovie>.toListMovie(): List<MoviesState.Movie> = this.map { it.toMovie() }
fun DbMovie.toMovie(): MoviesState.Movie = with(this){
    MoviesState.Movie(
        id = id,
        synopsis = synopsis ?: "",
        posterPath = posterPath?: "",
        releaseDate = releaseDate?: "",
        title = title?: "",
        voteAverage = voteAverage?: 0.0,
    )
}

fun List<MoviesState.Movie>.toDbMovie(): List<DbMovie> = this.map { it.toDbMovie() }
fun MoviesState.Movie.toDbMovie(): DbMovie = with(this){
    DbMovie(
        id = id,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
    )
}