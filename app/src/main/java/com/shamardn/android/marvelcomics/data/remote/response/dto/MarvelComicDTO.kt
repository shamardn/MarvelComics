package com.shamardn.android.marvelcomics.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelUrlDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO

data class MarvelComicDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailDTO?,
    @SerializedName("urls")
    val urls: List<MarvelUrlDTO>?,
    @SerializedName("pageCount")
    val pageCount: Int?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelBasicDTO>?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelBasicDTO>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelBasicDTO>?,
)