package com.shamardn.android.marvelcomics.domain.model

data class MarvelList<T>(
    val available: Int,
    val collectionURI: String,
    val items: List<T>,
)
