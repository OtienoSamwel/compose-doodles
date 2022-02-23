package com.os.compose_doodles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.os.compose_doodles.ui.presentation.home.Home
import com.os.compose_doodles.ui.theme.ComposedoodlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedoodlesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}