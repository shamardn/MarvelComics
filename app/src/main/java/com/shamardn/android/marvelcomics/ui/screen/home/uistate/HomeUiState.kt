package com.shamardn.android.marvelcomics.ui.screen.home.uistate

import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState

data class HomeUiState(
    val marvelCharacters: List<CharacterDetailsUiState> = emptyList(),
    val marvelComics: List<ComicDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)