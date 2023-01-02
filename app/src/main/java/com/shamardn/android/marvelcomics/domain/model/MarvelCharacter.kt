package com.shamardn.android.marvelcomics.domain.model

import java.util.*

data class MarvelCharacter(
    val id: Int,
    val title: String,
    val description: String,
    val modifiedDate: Date,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: MarvelList<MarvelBasic>,
    val series: MarvelList<MarvelBasic>,
    val stories: MarvelList<MarvelBasic>,
)
