package com.jersson.diaz.moviessofttek.data.movie.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "movie_table"
)
data class DbMovie(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "posterPath") val posterPath: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "voteAverage") val voteAverage: Double? = 0.0,
    @ColumnInfo(name = "releaseDate") val releaseDate: String?,
    @ColumnInfo(name = "synopsis") val synopsis: String?,
)
