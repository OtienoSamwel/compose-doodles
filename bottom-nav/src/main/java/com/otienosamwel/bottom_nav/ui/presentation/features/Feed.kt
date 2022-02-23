package com.otienosamwel.bottom_nav.ui.presentation.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Feed() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Feed", style = MaterialTheme.typography.h2)
    }
}