package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.CharactersMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import javax.inject.Inject

class FetchMarvelCharactersByComicIdUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val charactersMapper: CharactersMapper
){
     suspend operator fun invoke(comicId: Int): List<MarvelCharacter> {
         return charactersMapper.map(marvelRepository.getCharactersByComicId(comicId))
    }
}
