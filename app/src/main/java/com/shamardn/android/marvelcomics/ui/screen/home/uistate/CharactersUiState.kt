package com.shamardn.android.marvelcomics.ui.screen.home.uistate

import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState

data class CharactersUiState(
    val marvelCharacters: List<CharacterDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)