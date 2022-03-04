package com.otienosamwel.nav_rail.ui.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otienosamwel.nav_rail.ui.presentation.features.Account
import com.otienosamwel.nav_rail.ui.presentation.features.Feed
import com.otienosamwel.nav_rail.ui.presentation.features.Home

@Composable
fun Navigation() {

    val navController = rememberNavController()
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        SideNavigation(navController = navController)
        NavigationHost(navController = navController)
    }
}

@Composable
fun SideNavigation(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationRail(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
    ) {
        myScreens.forEachIndexed { index, screen ->
            NavigationRailItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index; navController.navigate(screen.route) },
                icon = { Icon(screen.Icon, contentDescription = screen.name) },
                label = { Text(text = screen.name) }
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.fillMaxWidth()
    ) {
        composable(route = "home") { Home() }
        composable(route = "feed") { Feed() }
        composable(route = "account") { Account() }
    }
}

sealed class Screen(val route: String, val name: String, val Icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Rounded.Home)
    object Feed : Screen("feed", "Feed", Icons.Rounded.Favorite)
    object Account : Screen("account", "Account", Icons.Rounded.AccountCircle)
}

val myScreens = listOf(Screen.Home, Screen.Feed, Screen.Account)