package com.shamardn.android.marvelcomics.ui.screen.comicDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState
import javax.inject.Inject

class ComicsUiStateMapper @Inject constructor(
    private val characterByComicIdUiStateMapper: CharacterByComicIdUiStateMapper,
): Mapper<MarvelComic, ComicDetailsUiState>(){
    override fun map(input: MarvelComic): ComicDetailsUiState {
        return ComicDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
//            modifiedDate = input.modifiedDate,
            thumbnail = input.thumbnail,
//            resourceURI = input.resourceURI,
            characters = characterByComicIdUiStateMapper.map(input.characters),
//            series = comicByCharacterIdUiStateMapper.map(input.series),
        )
    }
}