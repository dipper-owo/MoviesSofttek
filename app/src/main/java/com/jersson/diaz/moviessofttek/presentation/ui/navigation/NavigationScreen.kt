package com.jersson.diaz.moviessofttek.presentation.ui.navigation

sealed class NavigationScreen(val screen: String) {
    object LoginScreen: NavigationScreen("login_screen")
    object MoviesScreen: NavigationScreen("movies_screen")
    object DetailScreen: NavigationScreen("detail_screen")
}