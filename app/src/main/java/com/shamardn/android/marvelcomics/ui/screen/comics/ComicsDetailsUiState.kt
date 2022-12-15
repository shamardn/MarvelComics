package com.shamardn.android.marvelcomics.ui.screen.comics

import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import java.util.*

data class ComicsDetailsUiState(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val modifiedDate: Date = Date(),
    val thumbnail: Thumbnail = Thumbnail("",""),
    val resourceURI: String = "",
)
