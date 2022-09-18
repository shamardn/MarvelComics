package com.shamardn.android.marvelcomics.data.model.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelThumbnail(
    @SerializedName("path") val path: String  ,
    @SerializedName("extension") val extension: String ,
):Parcelable
