package com.os.compose_doodles.ui.presentation.home

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        DoodleCard(
            name = "Bottom Navigation",
            description = "A bottom navigation layout in compose using a scaffold and compose navigation to manage navigation state"
        )
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DoodleCard(name: String, description: String) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        border = BorderStroke(1.dp, color = MaterialTheme.colors.primary),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = name, style = MaterialTheme.typography.h4)
            AnimatedVisibility(visible = expanded) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = description)
                    TextButton(onClick = {
                        context.startActivity(
                            Intent(
                                context,
                                Class.forName("com.otienosamwel.bottom_nav.BottomNavActivity")
                            )
                        )
                    }) {
                        Text(text = "Go")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoodleCardPreview() {
    DoodleCard(name = "Preview name", description = "Test description for the card view")
}
