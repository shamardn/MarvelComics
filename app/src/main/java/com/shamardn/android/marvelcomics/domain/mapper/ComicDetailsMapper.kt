package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class ComicDetailsMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
    private val marvelByComicIdMapper: MarvelByComicIdMapper,
) : Mapper<BaseResponse<MarvelComicDTO>, MarvelComic>() {
    override fun map(input: BaseResponse<MarvelComicDTO>): MarvelComic {
        var thumbnailNotNull =
            ThumbnailDTO(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73",
                extension = "jpg",
            )
        if (input.data?.results?.first()?.thumbnail != null) {
            thumbnailNotNull = input.data.results.first().thumbnail!!
        }
        return MarvelComic(
            id = input.data?.results?.first()?.id ?: 0,
            title = input.data?.results?.first()?.title ?: "",
            description = input.data?.results?.first()?.description ?: "",
            modifiedDate = convertStringToDate(input.data?.results?.first()?.modified),
            thumbnail = thumbnailMapper.map(thumbnailNotNull),
//            resourceURI = input.data?.results?.first()?.resourceURI ?: "",
            characters = marvelByComicIdMapper.map(input.data?.results?.first()?.characters!!),
//            series = marvelByCharacterIdMapper.map(input.data?.results?.first()?.series!!),
        )
    }
}