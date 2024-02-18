package com.jersson.diaz.moviessofttek.presentation.ui.list

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.util.Function
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.model.UiStateHolder
import com.jersson.diaz.moviessofttek.presentation.ui.list.screen.EmptyState
import com.jersson.diaz.moviessofttek.presentation.ui.list.screen.ErrorState
import com.jersson.diaz.moviessofttek.presentation.ui.list.screen.LoadingState
import com.jersson.diaz.moviessofttek.presentation.ui.list.screen.SuccessState

@Composable
fun ListScreen(
    list: List<MoviesState.Movie>,
    goDetail: Function<MoviesState.Movie, Unit>,
    uiState: UiStateHolder,
    finish: Runnable,
) {
    BackHandler {
        finish.run()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EmptyState(uiState.isEmptyVisible)

        ErrorState(uiState.isErrorVisible)

        LoadingState(uiState.isLoadingVisible)

        SuccessState(uiState.isSuccessVisible, list, goDetail)
    }
}