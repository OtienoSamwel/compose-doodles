package com.os.compose_doodles.ui.presentation.autocompleteTextView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object AutoCompleteState {
    private val allSuggestions = listOf("sam", "david", "mary", "jude", "sandra", "william")
    var suggestions: MutableList<String> = mutableStateListOf()

    var hasSelected by mutableStateOf(false)

    var text by mutableStateOf("")

    val onChange: (String) -> Unit = { newText ->
        hasSelected = false
        text = newText
        suggestions = mutableListOf()
        if (newText != "") suggestions = allSuggestions.filter { it.lowercase().contains(newText) }.toMutableList()
    }
}