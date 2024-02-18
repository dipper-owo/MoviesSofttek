package com.jersson.diaz.moviessofttek.presentation.ui.navigation

import androidx.core.util.Function
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jersson.diaz.moviessofttek.presentation.ui.login.LoginScreen
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.model.UiStateHolder
import com.jersson.diaz.moviessofttek.presentation.ui.detail.DetailScreen
import com.jersson.diaz.moviessofttek.presentation.ui.list.ListScreen

fun NavGraphBuilder.graph(
    state: () -> MoviesState,
    uiState: () -> UiStateHolder,
    validateUser: Function<MoviesState.User, Unit>,
    goDetail: Function<MoviesState.Movie, Unit>,
    finish: Runnable,
) {
    navigation(
        startDestination = NavigationScreen.LoginScreen.screen,
        route = NavigationHost.InitNavHost.route
    ) {
        composable(NavigationScreen.LoginScreen.screen){
            LoginScreen(
                validateUser = validateUser,
                uiState = uiState.invoke(),
            )
        }
        composable(NavigationScreen.MoviesScreen.screen){
            ListScreen(
                list = state().listMovies,
                goDetail = goDetail,
                uiState = uiState.invoke(),
                finish = finish,
            )
        }
        composable(NavigationScreen.DetailScreen.screen){
            DetailScreen(
                movie = state().movieSelected,
            )
        }
    }
}