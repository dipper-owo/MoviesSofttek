package com.jersson.diaz.moviessofttek.data.movie.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jersson.diaz.moviessofttek.data.movie.local.dao.MovieDao
import com.jersson.diaz.moviessofttek.data.movie.local.model.DbMovie

@Database(
    entities =[
        DbMovie::class
    ],
    version = 1
)
abstract class MovieDataBase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
}