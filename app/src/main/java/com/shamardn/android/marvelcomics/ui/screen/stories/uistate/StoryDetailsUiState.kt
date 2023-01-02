package com.shamardn.android.marvelcomics.ui.screen.stories.uistate

import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.MarvelListUiState
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.MarvelBasicUiState
import java.util.Date

data class StoryDetailsUiState(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val modified: Date = Date(),
    val thumbnail: Thumbnail = Thumbnail("",""),
    val characters: MarvelListUiState<MarvelBasicUiState> = MarvelListUiState(available = 0, collectionURI = "", items = emptyList()),
    val comics: MarvelListUiState<MarvelBasicUiState> = MarvelListUiState(available = 0, collectionURI = "", items = emptyList()),
    val series: MarvelListUiState<MarvelBasicUiState> = MarvelListUiState(available = 0, collectionURI = "", items = emptyList()),
)
