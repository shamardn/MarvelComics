package com.shamardn.android.marvelcomics.ui.screen.comics.uistate

data class MarvelListUiState<T>(
    val available: Int,
    val collectionURI: String,
    val items: List<T>,
)
