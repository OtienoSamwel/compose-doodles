package com.os.compose_doodles.ui.presentation.selectChip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SelectChips() {
    val items: List<Int> = (0..25).toList()
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = items.chunked((1..4).random())) { its: List<Int> ->
            Row {
                its.forEach {
                    SelectChip(it = it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SelectChip(it: Int) {
    Chip(
        onClick = { },
        border = BorderStroke(ChipDefaults.OutlinedBorderSize, Color.Red),
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description"
            )
        },
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text = "Chip #$it")
    }
}
