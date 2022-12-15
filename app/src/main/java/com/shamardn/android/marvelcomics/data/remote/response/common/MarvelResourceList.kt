package com.shamardn.android.marvelcomics.data.remote.response.common

import com.google.gson.annotations.SerializedName

data class MarvelResourceList<T>(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("items")
    val items: List<T>?
)
