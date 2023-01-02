package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelStoryDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class StoryDetailsMapper @Inject constructor(
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelStoryDTO>, MarvelStory>() {
    override fun map(input: BaseResponse<MarvelStoryDTO>): MarvelStory {
        return MarvelStory(
            id = input.data?.results?.first()?.id ?: 0,
            title = input.data?.results?.first()?.title ?: "",
            description = input.data?.results?.first()?.description ?: "",
            modifiedDate = convertStringToDate(input.data?.results?.first()?.modified),
            comics = marvelByCharacterIdMapper.map(input.data?.results?.first()?.comics!!),
            series = marvelByCharacterIdMapper.map(input.data.results.first().series!!),
            characters = marvelByCharacterIdMapper.map(input.data.results.first().characters!!),
        )
    }
}