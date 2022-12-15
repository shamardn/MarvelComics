package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.toMarvelCharacter
import com.shamardn.android.marvelcomics.domain.model.MarvelCharacter
import javax.inject.Inject

class GetMarvelCharactersUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
){
     suspend operator fun invoke(): List<MarvelCharacter>? {
         return marvelRepository.getMarvelCharacters()?.data?.results?.map { it.toMarvelCharacter( it.thumbnail?.path!!, it.thumbnail.extension!!) }
    }
}
