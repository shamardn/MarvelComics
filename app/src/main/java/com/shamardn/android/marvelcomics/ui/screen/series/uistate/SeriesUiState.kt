package com.shamardn.android.marvelcomics.ui.screen.series.uistate

data class SeriesUiState(
    val marvelSeries: List<SeriesDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)