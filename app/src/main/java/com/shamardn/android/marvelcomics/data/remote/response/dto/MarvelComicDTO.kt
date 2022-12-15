package com.shamardn.android.marvelcomics.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelUrl
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO

data class MarvelComicDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailDTO?,
    @SerializedName("urls")
    val urls: List<MarvelUrl>?,
    @SerializedName("pageCount")
    val pageCount: Int?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelCharacterDTO>?,
)