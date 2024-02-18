package com.jersson.diaz.moviessofttek.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Routing(
    navController: NavController,
    uiEvents: SharedFlow<UIEvents>,
){
    LaunchedEffect(key1 = null){
        uiEvents.collect{ uiEvents ->
            when(uiEvents){
                UIEvents.GoMovies ->{
                    navController.navigate(NavigationScreen.MoviesScreen.screen)
                }
                UIEvents.GoDetail -> {
                    navController.navigate(NavigationScreen.DetailScreen.screen)
                }
            }
        }
    }
}