package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelStoryDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import com.shamardn.android.marvelcomics.utils.convertStringToDate
import javax.inject.Inject

class StoriesMapper @Inject constructor(
    private val marvelByCharacterIdMapper: MarvelByCharacterIdMapper,
) : Mapper<BaseResponse<MarvelStoryDTO>, List<MarvelStory>>() {
    override fun map(input: BaseResponse<MarvelStoryDTO>): List<MarvelStory> {
        var result = listOf<MarvelStoryDTO>()
        if (input.data?.results != null ){
            result = input.data.results
        }
        return result.map {
            MarvelStory(
                id = it.id ?: 0,
                title = it.title ?: "",
                description = it.description ?: "",
                modifiedDate = convertStringToDate(it.modified),
                characters = marvelByCharacterIdMapper.map(it.characters!!),
                comics = marvelByCharacterIdMapper.map(it.comics!!) ,
                series = marvelByCharacterIdMapper.map(it.series!!),
            )
        }
    }
}