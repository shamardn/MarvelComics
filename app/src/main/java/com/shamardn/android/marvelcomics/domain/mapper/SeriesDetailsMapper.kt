package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelSeries
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class SeriesDetailsMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelSeriesDTO>, MarvelSeries>() {
    override fun map(input: BaseResponse<MarvelSeriesDTO>): MarvelSeries {
        var thumbnailNotNull =
            ThumbnailDTO(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73",
                extension = "jpg",
            )
        if (input.data?.results?.first()?.thumbnail != null) {
            thumbnailNotNull = input.data.results.first().thumbnail!!
        }
        return MarvelSeries(
            id = input.data?.results?.first()?.id ?: 0,
            title = input.data?.results?.first()?.title ?: "",
            description = input.data?.results?.first()?.description ?: "",
            modifiedDate = convertStringToDate(input.data?.results?.first()?.modified),
            thumbnail = thumbnailMapper.map(thumbnailNotNull),
            characters = marvelByCharacterIdMapper.map(input.data?.results?.first()?.characters!!),
            comics = marvelByCharacterIdMapper.map(input.data.results.first().comics!!),
            stories = marvelByCharacterIdMapper.map(input.data.results.first().stories!!),

        )
    }
}