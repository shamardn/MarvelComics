package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val thumbnailMapper: ThumbnailMapper,
) : Mapper<BaseResponse<MarvelCharacterDTO>, List<MarvelCharacter>>() {
    override fun map(input: BaseResponse<MarvelCharacterDTO>): List<MarvelCharacter> {
        var result = listOf<MarvelCharacterDTO>()
        if (input.data?.results != null ){
            result = input.data.results
        }
        return result.map {
            MarvelCharacter(
                id = it.id ?: 0,
                name = it.name ?: "",
                description = it.description ?: "",
                modifiedDate = convertStringToDate(it.modified),
                thumbnail = thumbnailMapper.map(it.thumbnail!!),
                resourceURI = it.resourceURI ?: "",
            )
        }
    }
}