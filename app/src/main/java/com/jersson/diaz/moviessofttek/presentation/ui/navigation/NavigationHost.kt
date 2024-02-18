package com.jersson.diaz.moviessofttek.presentation.ui.navigation

sealed class NavigationHost(val route: String) {
    object InitNavHost : NavigationHost("navigation_host")
}
