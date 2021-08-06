package com.example.simple_compose_app.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.simple_compose_app.data.Movie

import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.simple_compose_app.data.movies

@Composable
fun DetailScreen(movie: Movie) {

    val listState = rememberLazyListState()

    DetailScaffold(
    ) {
        LazyColumn(state = listState) {
            item {
                Header(name = movie.name, imageUrl = movie.backdropImage)
            }
            item {
                Spacer(modifier = Modifier.requiredHeight(8.dp))
            }
            item {
                Text(
                    text = movie.overview,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Justify,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}

@Composable
fun DetailScaffold(
    content: @Composable () -> Unit,
) {
    val backgroundColor = Color.Transparent
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize(), content = content)
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            title = { "Detail Activity" },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null
                    )
                }
            },
            backgroundColor = backgroundColor,
            contentColor = Color.White,
            elevation = 0.dp
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Header(name: String, imageUrl: String) {

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (image, info, fab) = createRefs()
        Image(
            painter = rememberImagePainter(
                data = imageUrl
            ),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1.77f)
                .constrainAs(image) {
                    width = Dimension.fillToConstraints
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        top = parent.top,
                        bottom = info.top
                    )
                },
            contentScale = ContentScale.Crop
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp)
                .constrainAs(info) {
                    width = Dimension.fillToConstraints
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        top = image.bottom,
                        bottom = parent.bottom
                    )
                },
            shape = RectangleShape,
            backgroundColor = MaterialTheme.colors.primarySurface
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 70.dp)
                        .fillMaxWidth()
                )
            }
        }

        Box(
            modifier = Modifier
                .constrainAs(fab) {
                    end.linkTo(parent.end, margin = 16.dp)
                    linkTo(
                        top = info.top,
                        bottom = info.top
                    )
                }
        ) {
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Red,
                contentColor = MaterialTheme.colors.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null)
            }
        }
    }
}
