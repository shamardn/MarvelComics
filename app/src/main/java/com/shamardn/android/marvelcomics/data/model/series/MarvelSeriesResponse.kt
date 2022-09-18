package com.shamardn.android.marvelcomics.data.model.series

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.model.common.MarvelCommonResponse

data class MarvelSeriesResponse(@SerializedName("data") val seriesData: MarvelSeriesData): MarvelCommonResponse()