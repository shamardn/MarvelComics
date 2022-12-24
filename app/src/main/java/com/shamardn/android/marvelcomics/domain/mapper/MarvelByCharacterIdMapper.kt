package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelResourceList
import com.shamardn.android.marvelcomics.domain.model.MarvelBasic
import com.shamardn.android.marvelcomics.domain.model.MarvelList
import javax.inject.Inject

class MarvelByCharacterIdMapper @Inject constructor(
    private val basicDTOToBasicMapper: BasicDTOToBasicMapper,
) : Mapper<MarvelResourceList<MarvelBasicDTO>, MarvelList<MarvelBasic>>() {
    override fun map(input: MarvelResourceList<MarvelBasicDTO>): MarvelList<MarvelBasic> {
        var itemDTO = emptyList<MarvelBasicDTO>()
        if (input.items != null){
            itemDTO = input.items
        }
        return MarvelList(
            available = input.available ?: 0,
            collectionURI = input.collectionURI ?: "",
            items = basicDTOToBasicMapper.mapList(itemDTO),
        )
    }

}