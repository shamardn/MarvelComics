package com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper

import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState

fun MarvelCharacter.toCharactersDetailsUiState(): CharacterDetailsUiState {
    return CharacterDetailsUiState(
        id = id,
        name = name,
        description = description,
        modifiedDate = modifiedDate,
        thumbnail = thumbnail,
        resourceURI = resourceURI,
    )
}