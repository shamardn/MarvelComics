package com.shamardn.android.marvelcomics.data.model.comics

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.model.common.MarvelThumbnail

data class MarvelComics(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("thumbnail") val thumbnail: MarvelThumbnail,
)