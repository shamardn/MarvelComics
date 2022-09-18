package com.shamardn.android.marvelcomics.data.model.hero

import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.model.common.MarvelCommonResponse

data class MarvelHeroResponse(@SerializedName("data") val heroData: MarvelHeroData): MarvelCommonResponse()