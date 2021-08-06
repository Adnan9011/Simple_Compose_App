package com.example.simple_compose_app.ui.screen

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.simple_compose_app.DetailActivity
import com.example.simple_compose_app.data.EXTRA_MOVIE
import com.example.simple_compose_app.data.movies

@Composable
fun MainScreen() {
    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
    ) {
        Box() {
            BackgroundOfScreen(index = 0)
            Column {
                Text(
                    text = "Best New Movies ",
                    style = TextStyle(
                        fontSize = 40.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 40.dp, start = 30.dp)
                )
                LoadImages()
            }
        }
    }
}

@Composable
fun BackgroundOfScreen(index: Int) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.15f),
        painter = rememberImagePainter(
            data = movies.get(index).posterImage
        ),
        contentScale = ContentScale.Crop,
        contentDescription = "Movie Picture"
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoadImages() {
    val scrollState = rememberScrollState()

    LazyRow(
        Modifier
            .verticalScroll(scrollState)
            .padding(top = 40.dp)
    ) {
        items(movies.size) {
            ImageItems(it)
        }
    }
}

@Composable
fun ImageItems(index: Int) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(top = 40.dp, start = 30.dp)
            .clickable {
                navigateToDetail(index, context)
            }
    ) {
        Image(
            modifier = Modifier
                .size(width = 200.dp, height = 300.dp)
                .clip(RoundedCornerShape(size = 50.dp)),
            painter = rememberImagePainter(
                data = movies.get(index).posterImage
            ),
            contentDescription = null
        )
        Text(
            text = movies.get(index).name,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 20.dp, start = 20.dp)
        )
    }
}

fun navigateToDetail(index: Int, context: Context) {
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra(EXTRA_MOVIE, movies.get(index = index))
    context.startActivity(intent)
}