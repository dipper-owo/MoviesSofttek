package com.jersson.diaz.moviessofttek.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.diaz.moviessofttek.data.local.entities.DbMovie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    fun getListDbMovie(): List<DbMovie>

    @Query("DELETE FROM movie_table")
    fun deleteAllMovies()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(dbMovie: DbMovie)
}