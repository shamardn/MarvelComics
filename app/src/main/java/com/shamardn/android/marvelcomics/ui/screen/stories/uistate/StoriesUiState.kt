package com.shamardn.android.marvelcomics.ui.screen.stories.uistate

data class StoriesUiState(
    val marvelStories: List<StoryDetailsUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
)