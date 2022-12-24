package com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import javax.inject.Inject

class CharactersUiStateMapper @Inject constructor(
    private val comicByCharacterIdUiStateMapper: ComicByCharacterIdUiStateMapper,
): Mapper<MarvelCharacter, CharacterDetailsUiState>(){
    override fun map(input: MarvelCharacter): CharacterDetailsUiState {
        return CharacterDetailsUiState(
            id = input.id,
            name = input.name,
            description = input.description,
            modifiedDate = input.modifiedDate,
            thumbnail = input.thumbnail,
            resourceURI = input.resourceURI,
            comics = comicByCharacterIdUiStateMapper.map(input.comics),
//            series = comicByCharacterIdUiStateMapper.map(input.series),
        )
    }
}