package com.otienosamwel.bottom_nav.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.otienosamwel.bottom_nav.ui.presentation.features.Account
import com.otienosamwel.bottom_nav.ui.presentation.features.Feed
import com.otienosamwel.bottom_nav.ui.presentation.features.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController = navController) }) {
        NavHost(navController = navController, startDestination = "home") {
            composable(route = "home") { Home() }
            composable(route = "feed") { Feed() }
            composable(route = "account") { Account() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        myScreens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                icon = { Icon(imageVector = screen.Icon, contentDescription = screen.name) },
                label = { Text(text = screen.name) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


sealed class Screen(val route: String, val name: String, val Icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Rounded.Home)
    object Feed : Screen("feed", "Feed", Icons.Rounded.Favorite)
    object Account : Screen("account", "Account", Icons.Rounded.AccountCircle)
}

val myScreens = listOf(Screen.Home, Screen.Feed, Screen.Account)
