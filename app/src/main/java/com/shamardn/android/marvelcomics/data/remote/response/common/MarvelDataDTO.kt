package com.shamardn.android.marvelcomics.data.remote.response.common

import com.google.gson.annotations.SerializedName

data class MarvelDataDTO<T>(
    @SerializedName("limit") val limit: Int?,
    @SerializedName("results") val results: List<T>?
)