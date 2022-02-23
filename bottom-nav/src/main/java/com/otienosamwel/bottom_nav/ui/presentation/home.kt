package com.otienosamwel.bottom_nav.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Testing module", style = MaterialTheme.typography.h1)
    }
}