package com.jersson.diaz.moviessofttek.domain.usecase

import com.jersson.diaz.moviessofttek.domain.repository.IMovieRepository
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.data.remote.MovieRemoteRepository
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository,
    private val repository: MovieRemoteRepository
) {
    suspend operator fun invoke(): List<MoviesState.Movie> {
        val movie = repository.getListMovies()
        val roomList = iMovieRepository.getListMovie()
        return if (roomList.isNotEmpty()){
            iMovieRepository.getListMovie()
        } else{
            if (movie!!.isNotEmpty()){
                movie.map {
                    iMovieRepository.insertMovies(it)
                }
                movie
            } else{
                iMovieRepository.getListMovie()
            }
        }
    }
}