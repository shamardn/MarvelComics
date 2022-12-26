package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelSeries
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class SeriesMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelSeriesDTO>, List<MarvelSeries>>() {
    override fun map(input: BaseResponse<MarvelSeriesDTO>): List<MarvelSeries> {
        var result = listOf<MarvelSeriesDTO>()
        if (input.data?.results != null ){
            result = input.data.results
        }
        return result.map {
            MarvelSeries(
                id = it.id ?: 0,
                title = it.title ?: "",
                description = it.description ?: "",
                modifiedDate = convertStringToDate(it.modified),
                thumbnail = thumbnailMapper.map(it.thumbnail!!),
                characters = marvelByCharacterIdMapper.map(it.characters!!),
                comics = marvelByCharacterIdMapper.map(it.comics!!),
            )
        }
    }
}