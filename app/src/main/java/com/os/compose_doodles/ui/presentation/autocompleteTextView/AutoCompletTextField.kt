package com.os.compose_doodles.ui.presentation.autocompleteTextView

import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties


@Composable
fun AutoCompleteTextScreen() {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        AutoCompleteTextView()
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AutoCompleteTextView() {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = AutoCompleteState.text,
            onValueChange = AutoCompleteState.onChange,
            label = { Text(text = "Choose a username") },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = !AutoCompleteState.hasSelected && AutoCompleteState.suggestions.isNotEmpty(),
            onDismissRequest = { },
            modifier = Modifier.wrapContentWidth(),
            properties = PopupProperties(focusable = false)
        ) {
            AutoCompleteState.suggestions.forEach { suggestion ->
                DropdownMenuItem(onClick = {
                    AutoCompleteState.text = suggestion
                    AutoCompleteState.hasSelected = true
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }) {
                    Text(text = suggestion)
                }
            }
        }
    }
}