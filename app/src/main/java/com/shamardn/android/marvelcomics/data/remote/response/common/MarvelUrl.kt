package com.shamardn.android.marvelcomics.data.remote.response.common

import com.google.gson.annotations.SerializedName

data class MarvelUrl(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
)