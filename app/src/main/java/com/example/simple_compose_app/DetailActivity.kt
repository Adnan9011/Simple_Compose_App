package com.example.simple_compose_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.simple_compose_app.data.EXTRA_MOVIE
import com.example.simple_compose_app.data.Movie
import com.example.simple_compose_app.data.movies
import com.example.simple_compose_app.ui.screen.DetailScreen
import com.example.simple_compose_app.ui.screen.MainScreen
import com.example.simple_compose_app.ui.theme.Simple_Compose_AppTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = intent?.let { it.extras!!.getParcelable<Movie>(EXTRA_MOVIE) } ?: movies.get(0)

        setContent {
            Simple_Compose_AppTheme {
                DetailScreen(movie)
            }
        }
    }
}