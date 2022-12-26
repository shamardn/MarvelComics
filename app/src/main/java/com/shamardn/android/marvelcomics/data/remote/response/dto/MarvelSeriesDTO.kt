package com.shamardn.android.marvelcomics.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelUrlDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO

data class MarvelSeriesDTO(
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
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelBasicDTO>?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelBasicDTO>?,
)