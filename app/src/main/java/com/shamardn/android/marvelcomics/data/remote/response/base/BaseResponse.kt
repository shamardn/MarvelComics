package com.shamardn.android.marvelcomics.data.remote.response.base

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelDataDTO

data class BaseResponse<T>(
    @SerializedName("data")
    val data: MarvelDataDTO<T>?,
)
