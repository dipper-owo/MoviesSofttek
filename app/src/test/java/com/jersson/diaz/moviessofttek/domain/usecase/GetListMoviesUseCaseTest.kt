package com.jersson.diaz.moviessofttek.domain.usecase

import com.jersson.diaz.moviessofttek.data.remote.MovieRemoteRepository
import com.jersson.diaz.moviessofttek.domain.repository.IMovieRepository
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetListMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var iMovieRepository: IMovieRepository

    @RelaxedMockK
    private lateinit var movieRemoteRepository: MovieRemoteRepository

    lateinit var useCase: GetListMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        useCase = GetListMoviesUseCase(iMovieRepository, movieRemoteRepository)
    }

    @Test
    fun `invoke should return success result with data`() = runTest {
        //Given
        val mockMovies = listOf<MoviesState.Movie>()
        coEvery { movieRemoteRepository.getListMovies() } returns mockMovies

        //When
        val response = useCase()

        //Then
        coVerify(exactly = 1) { movieRemoteRepository.getListMovies() }
        assert(response == mockMovies)
    }
}