package com.shamardn.android.marvelcomics.ui.screen.comics.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.ComicByCharacterIdUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState
import javax.inject.Inject

class ComicsUiStateMapper @Inject constructor(
    private val comicByCharacterIdUiStateMapper: ComicByCharacterIdUiStateMapper,
): Mapper<MarvelComic, ComicDetailsUiState>(){
    override fun map(input: MarvelComic): ComicDetailsUiState {
        return ComicDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            thumbnail = input.thumbnail,
            characters = comicByCharacterIdUiStateMapper.map(input.characters),
//            series = comicByCharacterIdUiStateMapper.map(input.series),
        )
    }
}