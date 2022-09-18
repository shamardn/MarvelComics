package com.shamardn.android.marvelcomics.data.model.comics

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.model.common.MarvelCommonResponse

data class MarvelComicsResponse(
    @SerializedName("data") val heroData: MarvelComicsData
): MarvelCommonResponse()