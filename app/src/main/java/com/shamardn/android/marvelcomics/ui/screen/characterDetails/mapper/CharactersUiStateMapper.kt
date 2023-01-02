package com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import javax.inject.Inject

class CharactersUiStateMapper @Inject constructor(
    private val marvelListBasicToUiStateMapper: MarvelListBasicToUiStateMapper,
): Mapper<MarvelCharacter, CharacterDetailsUiState>(){
    override fun map(input: MarvelCharacter): CharacterDetailsUiState {
        return CharacterDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            modifiedDate = input.modifiedDate,
            thumbnail = input.thumbnail,
            resourceURI = input.resourceURI,
            comics = marvelListBasicToUiStateMapper.map(input.comics),
            series = marvelListBasicToUiStateMapper.map(input.series),
            stories = marvelListBasicToUiStateMapper.map(input.stories),
        )
    }
}