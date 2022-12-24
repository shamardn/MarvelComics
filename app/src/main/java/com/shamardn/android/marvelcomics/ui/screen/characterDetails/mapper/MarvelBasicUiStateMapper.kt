package com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelBasic
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.MarvelBasicUiState
import javax.inject.Inject

class MarvelBasicUiStateMapper @Inject constructor(
): Mapper<MarvelBasic, MarvelBasicUiState>(){
    override fun map(input: MarvelBasic): MarvelBasicUiState {
        return MarvelBasicUiState(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }

}