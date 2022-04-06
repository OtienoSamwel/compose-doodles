package com.otienosamwel.bottom_nav.ui.presentation.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home", style = MaterialTheme.typography.headlineLarge)
    }
}