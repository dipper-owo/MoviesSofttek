package com.jersson.diaz.moviessofttek.presentation.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import coil.compose.rememberAsyncImagePainter
import com.jersson.diaz.moviessofttek.R
import com.jersson.diaz.moviessofttek.presentation.commons.URL_IMAGE
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.ui.theme.movieDetail
import com.jersson.diaz.moviessofttek.ui.theme.movieHeadboard

@Composable
fun MoviesItem(
    movie: MoviesState.Movie = MoviesState.Movie(),
    goDetail: Function<MoviesState.Movie, Unit>,
){
    Column(
        modifier = Modifier.clickable {
            goDetail.apply(movie)
        }
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .background(color = Color.White)
                .border(
                    width = 2.dp,
                    color = Color.Black
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(120.dp)
                        .weight(1f),
                    painter = rememberAsyncImagePainter(model = "$URL_IMAGE${movie.posterPath}"),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Text(
                        text = movie.title,
                        style = movieHeadboard,
                        maxLines = 1
                    )
                    Text(
                        text = movie.releaseDate,
                        style = movieDetail,
                        maxLines = 1
                    )
                    Text(
                        text = "${stringResource(id = R.string.detail_qualify)} ${movie.voteAverage}",
                        style = movieDetail,
                        maxLines = 1
                    )
                }
            }
        }
    }
}