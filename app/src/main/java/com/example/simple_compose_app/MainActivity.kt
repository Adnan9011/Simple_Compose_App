package com.example.simple_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.simple_compose_app.ui.screen.MainScreen
import com.example.simple_compose_app.ui.theme.Simple_Compose_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simple_Compose_AppTheme {
                MainScreen()
            }
        }
    }
}



