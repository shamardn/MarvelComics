package com.shamardn.android.marvelcomics.domain.model

import java.util.*

data class MarvelComic(
    val id: Int,
    val title: String,
    val description: String,
    val modifiedDate: Date,
    val thumbnail: Thumbnail,
    val characters: MarvelList<MarvelBasic>,
    val series: MarvelList<MarvelBasic>,
)
