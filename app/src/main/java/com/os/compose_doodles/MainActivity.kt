package com.os.compose_doodles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.os.compose_doodles.ui.presentation.autocompleteTextView.AutoCompleteTextScreen
import com.os.compose_doodles.ui.presentation.home.Home
import com.os.compose_doodles.ui.presentation.selectChip.SelectChips
import com.os.compose_doodles.ui.theme.ComposedoodlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedoodlesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController = navController) }
        composable("selectChips") { SelectChips() }
        composable("autoCompleteScreen") { AutoCompleteTextScreen() }
    }
}