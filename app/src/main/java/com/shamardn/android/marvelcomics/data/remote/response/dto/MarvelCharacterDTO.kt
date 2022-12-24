package com.shamardn.android.marvelcomics.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelUrl
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO

data class MarvelCharacterDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailDTO?,
    @SerializedName("urls")
    val urls: List<MarvelUrl>?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelBasicDTO>?,
//    @SerializedName("series")
//    val series: MarvelResourceList<MarvelBasicDTO>?,

)