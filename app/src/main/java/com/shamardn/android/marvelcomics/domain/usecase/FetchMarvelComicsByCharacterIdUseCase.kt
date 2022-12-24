package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.ComicsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import javax.inject.Inject

class FetchMarvelComicsByCharacterIdUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val comicsMapper: ComicsMapper
){
     suspend operator fun invoke(characterId: Int): List<MarvelComic> {
         return comicsMapper.map(marvelRepository.getComicsByCharacterId(characterId))
    }
}
