package com.shamardn.android.marvelcomics.ui.screen.comics.uistate

data class ComicsUiState(
    val marvelComics: List<ComicDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)