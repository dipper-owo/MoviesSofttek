package com.jersson.diaz.moviessofttek.presentation.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.diaz.moviessofttek.domain.usecase.GetListMoviesUseCase
import com.jersson.diaz.moviessofttek.presentation.model.UiState
import com.jersson.diaz.moviessofttek.presentation.ui.navigation.UIEvents
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.model.MutableUiStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ADMIN = "Admin"
private const val PASSWORD = "Password*123."

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getListMoviesUseCase: GetListMoviesUseCase,
): ViewModel() {


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
        viewModelScope.launch(Dispatchers.IO)  {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            val result = getListMoviesUseCase.invoke()
            _state.value = state.value.copy(
                listMovies = result
            )
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(result)
            )
        }
    }

}