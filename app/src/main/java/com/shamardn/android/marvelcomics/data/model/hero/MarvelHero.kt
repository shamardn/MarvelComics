package com.shamardn.android.marvelcomics.data.model.hero


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.shamardn.android.marvelcomics.data.model.common.MarvelThumbnail
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelHero(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("thumbnail") val thumbnail: MarvelThumbnail,
): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                TODO("thumbnail")) {
        }

        companion object : Parceler<MarvelHero> {

                override fun MarvelHero.write(parcel: Parcel, flags: Int) {
                        parcel.writeInt(id)
                        parcel.writeString(name)
                        parcel.writeString(description)
                }

                override fun create(parcel: Parcel): MarvelHero {
                        return MarvelHero(parcel)
                }
        }
}