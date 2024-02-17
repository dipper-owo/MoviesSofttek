package com.jersson.diaz.moviessofttek.presentation.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.model.UiStateHolder
import com.jersson.diaz.moviessofttek.presentation.ui.login.screen.ErrorState
import com.jersson.diaz.moviessofttek.presentation.ui.login.screen.SuccessState

@Composable
fun LoginScreen(
    validateUser: Function<MoviesState.User, Unit>,
    uiState: UiStateHolder,
){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SuccessState(validateUser)

        ErrorState(uiState.isErrorVisible)
    }
}