package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class CharacterDetailsMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelCharacterDTO>, MarvelCharacter>() {
    override fun map(input: BaseResponse<MarvelCharacterDTO>): MarvelCharacter {
        var thumbnailNotNull =
            ThumbnailDTO(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73",
                extension = "jpg",
            )
        if (input.data?.results?.first()?.thumbnail != null) {
            thumbnailNotNull = input.data.results.first().thumbnail!!
        }
        return MarvelCharacter(
            id = input.data?.results?.first()?.id ?: 0,
            name = input.data?.results?.first()?.name ?: "",
            description = input.data?.results?.first()?.description ?: "",
            modifiedDate = convertStringToDate(input.data?.results?.first()?.modified),
            thumbnail = thumbnailMapper.map(thumbnailNotNull),
            resourceURI = input.data?.results?.first()?.resourceURI ?: "",
            comics = marvelByCharacterIdMapper.map(input.data?.results?.first()?.comics!!),
//            series = marvelByCharacterIdMapper.map(input.data?.results?.first()?.series!!),
        )
    }
}