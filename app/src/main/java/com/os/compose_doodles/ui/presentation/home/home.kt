package com.os.compose_doodles.ui.presentation.home

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.os.compose_doodles.R

@Composable
fun Home(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        DoodleCard(
            name = "Bottom Navigation",
            description = stringResource(R.string.bottom_nav_description),
            className = "com.otienosamwel.bottom_nav.BottomNavActivity"
        )
        DoodleCard(
            name = "Google Maps With Compose",
            description = stringResource(R.string.google_maps_description),
            className = "com.otienosamwel.maps_compose.MapsActivity"
        )
        DoodleCard(
            name = "Navigation Rail Compose",
            description = "An implementation of the navigation rail with jetpack compose and material ui 3",
            className = "com.otienosamwel.nav_rail.NavRailActivity",
        )
        DoodleCard(
            name = "Select Chips",
            description = "An implementation of select chips with compose.",
            destination = "selectChips",
            navController = navController
        )

        DoodleCard(
            name = "AutoComplete TextView",
            description = "An autocomplete text view with suggestions implemented in jetpack compose.",
            destination = "autoCompleteScreen",
            navController = navController
        )

        DoodleCard(
            name = "Pagination in compose",
            description = "A simple pagination implementation",
            destination = "pagination",
            navController = navController
        )


    }
}

@Composable
fun DoodleCard(
    name: String,
    description: String,
    className: String? = null,
    destination: String? = null,
    navController: NavController? = null
) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colors.primary),
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = name, style = MaterialTheme.typography.h5)
            AnimatedVisibility(visible = expanded) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = description)
                    TextButton(onClick = {
                        className?.let { context.startActivity(Intent(context, Class.forName(it))) }
                        destination?.let { navController?.navigate(it) }
                    }) {
                        Text(text = "Go")
                    }
                }
            }
        }
    }
}
