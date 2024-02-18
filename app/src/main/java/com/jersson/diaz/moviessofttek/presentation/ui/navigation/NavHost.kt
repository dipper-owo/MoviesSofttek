package com.jersson.diaz.moviessofttek.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import com.jersson.diaz.moviessofttek.presentation.ui.MovieViewModel

@Composable
fun NavHost(
    viewModel: MovieViewModel = hiltViewModel(),
    finish: Runnable,
) {
    val navController= rememberNavController()

    Routing(
        navController = navController,
        uiEvents = viewModel.events,
    )

    NavHost(
        navController = navController,
        startDestination = NavigationHost.InitNavHost.route,
    ){
        graph(
            state = { viewModel.state.value },
            uiState = { viewModel.uiState.value },
            validateUser = viewModel::validateUser,
            goDetail = viewModel::goDetail,
            finish = finish,
        )
    }
}