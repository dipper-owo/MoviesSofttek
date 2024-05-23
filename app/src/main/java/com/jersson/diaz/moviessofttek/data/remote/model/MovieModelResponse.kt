package com.jersson.diaz.moviessofttek.data.remote.model

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("results") val listMovies: List<MovieResponse> = emptyList(),
)

data class MovieResponse(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("overview") val synopsis: String = "",
)