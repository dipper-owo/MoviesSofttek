package com.jersson.diaz.moviessofttek.presentation.ui.list.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.moviessofttek.R
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.presentation.ui.list.MoviesItem
import com.jersson.diaz.moviessofttek.ui.theme.movieHeadboard

@Composable
fun SuccessState(
    isVisible: Boolean,
    list: List<MoviesState.Movie>,
    goDetail: Function<MoviesState.Movie, Unit>,
){
    AnimatedVisibility(
        visibleState = MutableTransitionState(isVisible),
        enter = expandHorizontally(),
        exit = shrinkHorizontally()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.list_our_movies),
                style = movieHeadboard
            )
            LazyColumn {
                items(items = list){ movie ->
                    MoviesItem(
                        movie = movie,
                        goDetail = goDetail
                    )
                }
            }
        }
    }
}