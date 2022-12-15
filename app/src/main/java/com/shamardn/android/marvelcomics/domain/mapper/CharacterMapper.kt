package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import java.text.SimpleDateFormat
import java.util.*

fun MarvelCharacterDTO.toMarvelCharacter(path: String, extension: String): MarvelCharacter {
        return MarvelCharacter(
            id = id ?: 0,
            name = name ?: "",
            description = description ?: "",
            modifiedDate = modified?.convertStringToDate() ?: Date(),
           thumbnail = thumbnail?.toThumbnail(path, extension) ?: Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73","jpg"),
            resourceURI = resourceURI ?: ""
        )
    }

fun ThumbnailDTO.toThumbnail(path: String, extension: String): Thumbnail{
    return Thumbnail(path, extension)
}

fun String.convertStringToDate(): Date {
    return if (this.isEmpty()) {
        Date()
    } else {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
        formatter.parse(this) ?: Date()
    }
}

