package com.shamardn.android.marvelcomics.ui.screen.characters.mapper

import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState

fun MarvelCharacter.toCharactersDetailsUiState(): CharactersDetailsUiState {
    return CharactersDetailsUiState(
        id = id,
        name = name,
        description = description,
        modifiedDate = modifiedDate,
        thumbnail = thumbnail,
        resourceURI = resourceURI,
    )
}