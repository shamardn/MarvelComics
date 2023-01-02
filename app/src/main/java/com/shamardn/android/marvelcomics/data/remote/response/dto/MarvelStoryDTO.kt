package com.shamardn.android.marvelcomics.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList

data class MarvelStoryDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelBasicDTO>?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelBasicDTO>?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelBasicDTO>?,
)