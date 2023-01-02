package com.shamardn.android.marvelcomics.domain.model

import java.util.*

data class MarvelStory(
    val id: Int,
    val title: String,
    val description: String,
    val modifiedDate: Date,
    val characters: MarvelList<MarvelBasic>,
    val comics: MarvelList<MarvelBasic>,
    val series: MarvelList<MarvelBasic>,
)
