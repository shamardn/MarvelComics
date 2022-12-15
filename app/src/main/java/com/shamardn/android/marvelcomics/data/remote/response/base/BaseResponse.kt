package com.shamardn.android.marvelcomics.data.remote.response.base

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelData

data class BaseResponse<T>(
    @SerializedName("data")
    val data: MarvelData<T>?,
)
