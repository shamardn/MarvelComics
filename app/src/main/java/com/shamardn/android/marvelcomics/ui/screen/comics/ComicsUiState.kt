package com.shamardn.android.marvelcomics.ui.screen.comics

data class ComicsUiState(
    val marvelComics: List<ComicsDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)