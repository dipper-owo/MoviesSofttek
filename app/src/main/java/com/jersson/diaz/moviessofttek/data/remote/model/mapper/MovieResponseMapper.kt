package com.jersson.diaz.moviessofttek.data.remote.model.mapper

import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.data.remote.model.MovieResponse

fun List<MovieResponse>.toListMovie(): List<MoviesState.Movie> = this.map { it.toMovie() }
fun MovieResponse.toMovie(): MoviesState.Movie = with(this){
    MoviesState.Movie(
        id = id,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )
}