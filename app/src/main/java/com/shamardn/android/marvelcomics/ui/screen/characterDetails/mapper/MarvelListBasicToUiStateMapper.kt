package com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelBasic
import com.shamardn.android.marvelcomics.domain.model.MarvelList
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.MarvelListUiState
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.MarvelBasicUiState
import javax.inject.Inject

class MarvelListBasicToUiStateMapper @Inject constructor(
    private val marvelBasicUiStateMapper: MarvelBasicUiStateMapper,
) : Mapper<MarvelList<MarvelBasic>, MarvelListUiState<MarvelBasicUiState>>() {
    override fun map(input: MarvelList<MarvelBasic>): MarvelListUiState<MarvelBasicUiState> {
        return MarvelListUiState(
            available = input.available,
            collectionURI = input.collectionURI,
            items = marvelBasicUiStateMapper.mapList(input.items)
        )
    }
}