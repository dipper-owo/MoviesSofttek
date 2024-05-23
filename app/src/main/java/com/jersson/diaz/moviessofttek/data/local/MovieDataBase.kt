package com.jersson.diaz.moviessofttek.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jersson.diaz.moviessofttek.data.local.dao.MovieDao
import com.jersson.diaz.moviessofttek.data.local.entities.DbMovie

@Database(
    entities =[
        DbMovie::class
    ],
    version = 1
)
abstract class MovieDataBase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
}