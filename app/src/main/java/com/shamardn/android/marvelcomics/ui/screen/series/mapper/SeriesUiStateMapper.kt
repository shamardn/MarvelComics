package com.shamardn.android.marvelcomics.ui.screen.series.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelSeries
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.MarvelListBasicToUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesDetailsUiState
import javax.inject.Inject

class SeriesUiStateMapper @Inject constructor(
    private val marvelListBasicToUiStateMapper: MarvelListBasicToUiStateMapper,
): Mapper<MarvelSeries, SeriesDetailsUiState>(){
    override fun map(input: MarvelSeries): SeriesDetailsUiState {
        return SeriesDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            modified = input.modifiedDate,
            thumbnail = input.thumbnail,
            characters = marvelListBasicToUiStateMapper.map(input.characters),
            comics = marvelListBasicToUiStateMapper.map(input.comics),
            stories = marvelListBasicToUiStateMapper.map(input.stories),
        )
    }
}