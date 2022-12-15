package com.shamardn.android.marvelcomics.ui.screen.characters.uistate

data class CharactersUiState(
    val marvelCharacters: List<CharactersDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)