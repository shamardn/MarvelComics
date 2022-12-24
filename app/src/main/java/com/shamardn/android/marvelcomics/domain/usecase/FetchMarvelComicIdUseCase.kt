package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.ComicDetailsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelComic
import javax.inject.Inject

class FetchMarvelComicIdUseCase @Inject constructor(
   private val marvelRepository: MarvelRepository,
   private val comicDetailsMapper: ComicDetailsMapper
) {
    suspend operator fun invoke(comicId: Int): MarvelComic {
        return comicDetailsMapper.map( marvelRepository.getComicId(comicId) )
    }
}