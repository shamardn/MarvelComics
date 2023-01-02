package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.StoriesMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import javax.inject.Inject

class FetchMarvelStoriesByCharacterIdUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val storiesMapper: StoriesMapper
){
     suspend operator fun invoke(characterId: Int): List<MarvelStory> {
         return storiesMapper.map(marvelRepository.getStoriesByCharacterId(characterId))
    }
}
