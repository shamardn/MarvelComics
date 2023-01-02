package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class ComicsMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelComicDTO>, List<MarvelComic>>() {
    override fun map(input: BaseResponse<MarvelComicDTO>): List<MarvelComic> {
        var result = listOf<MarvelComicDTO>()
        if (input.data?.results != null ){
            result = input.data.results
        }
        return result.map {
            MarvelComic(
                id = it.id ?: 0,
                title = it.title ?: "",
                description = it.description ?: "",
                modifiedDate = convertStringToDate(it.modified),
                thumbnail = thumbnailMapper.map(it.thumbnail!!),
                characters = marvelByCharacterIdMapper.map(it.characters!!),
                series = marvelByCharacterIdMapper.map(it.series!!),
                stories = marvelByCharacterIdMapper.map(it.stories!!),
            )
        }
    }
}