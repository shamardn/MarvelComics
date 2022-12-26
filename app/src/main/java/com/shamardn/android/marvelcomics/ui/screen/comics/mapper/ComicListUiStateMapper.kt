package com.shamardn.android.marvelcomics.ui.screen.comics.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.MarvelListBasicToUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState
import javax.inject.Inject

class ComicsUiStateMapper @Inject constructor(
    private val marvelListBasicToUiStateMapper: MarvelListBasicToUiStateMapper,
): Mapper<MarvelComic, ComicDetailsUiState>(){
    override fun map(input: MarvelComic): ComicDetailsUiState {
        return ComicDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            thumbnail = input.thumbnail,
            characters = marvelListBasicToUiStateMapper.map(input.characters),
            series = marvelListBasicToUiStateMapper.map(input.series),
        )
    }
}