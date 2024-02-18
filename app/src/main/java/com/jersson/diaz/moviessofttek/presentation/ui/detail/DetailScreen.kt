package com.jersson.diaz.moviessofttek.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jersson.diaz.moviessofttek.presentation.commons.URL_IMAGE
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.R
import com.jersson.diaz.moviessofttek.ui.theme.movieDetail
import com.jersson.diaz.moviessofttek.ui.theme.movieHeadboard

@Composable
fun DetailScreen(
    movie: MoviesState.Movie
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.fillMaxSize().weight(1f),
            painter = rememberAsyncImagePainter(model = "$URL_IMAGE${movie.posterPath}"),
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxSize().weight(2f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                text = movie.title,
                style = movieHeadboard,
                textAlign = TextAlign.Center,
            )
            Text(
                text = movie.releaseDate,
                style = movieDetail,
                maxLines = 1,
            )
            Text(
                text = "${stringResource(id = R.string.detail_qualify)} ${movie.voteAverage}",
                style = movieDetail,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = movie.synopsis,
                style = movieDetail,
            )
        }
    }
}