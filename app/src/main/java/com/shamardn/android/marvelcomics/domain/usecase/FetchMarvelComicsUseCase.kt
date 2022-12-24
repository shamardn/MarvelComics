package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.ComicsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import javax.inject.Inject

class FetchMarvelComicsUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val comicsMapper: ComicsMapper,
){
     suspend operator fun invoke(): List<MarvelComic> {
         return comicsMapper.map(marvelRepository.getMarvelComics())
    }
}
