package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.CharacterMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import javax.inject.Inject

class GetMarvelCharactersUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val characterMapper: CharacterMapper,
){
     suspend operator fun invoke(): List<MarvelCharacter> {
         return characterMapper.map(marvelRepository.getMarvelCharacters())
    }
}
