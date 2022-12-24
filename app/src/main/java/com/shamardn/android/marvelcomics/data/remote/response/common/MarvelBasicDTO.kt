package com.shamardn.android.marvelcomics.data.remote.response.common

import com.google.gson.annotations.SerializedName

data class MarvelBasicDTO(
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("name")
    val name: String?,
)
