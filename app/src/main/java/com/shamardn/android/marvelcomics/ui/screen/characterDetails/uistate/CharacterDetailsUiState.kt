package com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate

import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.MarvelListUiState
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.MarvelBasicUiState
import java.util.*

data class CharacterDetailsUiState(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val modifiedDate: Date = Date(),
    val thumbnail: Thumbnail = Thumbnail("","jpg"),
    val resourceURI: String = "",
    val comics: MarvelListUiState<MarvelBasicUiState> = MarvelListUiState(available = 0, collectionURI = "", items = emptyList()),
    val series: MarvelListUiState<MarvelBasicUiState> = MarvelListUiState(available = 0, collectionURI = "", items = emptyList()),
)