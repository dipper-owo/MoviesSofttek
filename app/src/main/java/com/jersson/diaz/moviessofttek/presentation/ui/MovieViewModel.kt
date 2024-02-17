package com.jersson.diaz.moviessofttek.presentation.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.diaz.moviessofttek.presentation.model.UiState
import com.jersson.diaz.moviessofttek.presentation.ui.navigation.UIEvents
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.model.MutableUiStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ADMIN = "Admin"
private const val PASSWORD = "Password*123."

@HiltViewModel
class MovieViewModel @Inject constructor(): ViewModel() {


    private var _uiState = mutableStateOf(MutableUiStateHolder())
    val uiState: State<MutableUiStateHolder> = _uiState

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents>
        get() = _events

    private var _state = mutableStateOf(MoviesState())

    val state: State<MoviesState>
        get() = _state

    fun validateUser(user: MoviesState.User){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            delay(3000)
            if (user.user != ADMIN && user.password != PASSWORD){
                _events.emit(UIEvents.GoMovies)
                getData()
            } else{
                _uiState.value = uiState.value.copy(
                    currentState = UiState.ERROR
                )
            }
        }
    }

    fun goDetail(movie: MoviesState.Movie){
        _state.value = state.value.copy(
            movieSelected = movie,
        )
        viewModelScope.launch {
            _events.emit(UIEvents.GoDetail)
        }
    }

    private fun getData(){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            delay(3000)
            _state.value = state.value.copy(
                listMovies = listOf(
                    MoviesState.Movie(
                        id = 634492,
                        posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
                        title = "Madame Web",
                        voteAverage = 5.521,
                        releaseDate = "2024-02-14",
                        synopsis = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
                    ),
                    MoviesState.Movie(
                        id = 634492,
                        posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
                        title = "Madame Web 2",
                        voteAverage = 5.521,
                        releaseDate = "2024-02-14",
                        synopsis = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
                    ),
                    MoviesState.Movie(
                        id = 634492,
                        posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
                        title = "Madame Web 3",
                        voteAverage = 5.521,
                        releaseDate = "2024-02-14",
                        synopsis = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
                    ),
                    MoviesState.Movie(
                        id = 634492,
                        posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
                        title = "Madame Web 4",
                        voteAverage = 5.521,
                        releaseDate = "2024-02-14",
                        synopsis = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
                    ),
                    MoviesState.Movie(
                        id = 634492,
                        posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
                        title = "Madame Web 5",
                        voteAverage = 5.521,
                        releaseDate = "2024-02-14",
                        synopsis = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
                    ),
                )
            )
            //Success
            val list = listOf("")
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(list)
            )
        }
    }

}