package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.CharacterDetailsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import javax.inject.Inject

class FetchCharacterIdUseCase @Inject constructor(
   private val marvelRepository: MarvelRepository,
   private val characterDetailsMapper: CharacterDetailsMapper
) {
    suspend operator fun invoke(characterId: Int): MarvelCharacter {
        return characterDetailsMapper.map( marvelRepository.getCharacterId(characterId) )
    }
}