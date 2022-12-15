package com.shamardn.android.marvelcomics.data.remote.response.common

import com.google.gson.annotations.SerializedName

data class ThumbnailDTO(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
)