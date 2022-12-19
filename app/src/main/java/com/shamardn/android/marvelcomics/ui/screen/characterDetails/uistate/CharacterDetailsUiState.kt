package com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate

import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import java.util.*

data class CharacterDetailsUiState(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val modifiedDate: Date = Date(),
    val thumbnail: Thumbnail = Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73","jpg"),
    val resourceURI: String = "",
)