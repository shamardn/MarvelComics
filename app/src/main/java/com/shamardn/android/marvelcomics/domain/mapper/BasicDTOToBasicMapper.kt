package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.common.MarvelBasicDTO
import com.shamardn.android.marvelcomics.domain.model.MarvelBasic
import javax.inject.Inject

class BasicDTOToBasicMapper @Inject constructor(
): Mapper<MarvelBasicDTO, MarvelBasic>(){
    override fun map(input: MarvelBasicDTO): MarvelBasic {
        return MarvelBasic(
            resourceURI = input.resourceURI ?: "",
            name = input.name ?: "",
        )
    }

}