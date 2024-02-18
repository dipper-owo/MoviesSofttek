package com.jersson.diaz.moviessofttek.presentation.model

data class MutableUiStateHolder(override var currentState: UiState = UiState.INIT) : UiStateHolder