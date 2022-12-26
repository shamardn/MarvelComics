package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.SeriesDetailsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelSeries
import javax.inject.Inject

class FetchMarvelSeriesIdUseCase @Inject constructor(
   private val marvelRepository: MarvelRepository,
   private val seriesDetailsMapper: SeriesDetailsMapper
) {
    suspend operator fun invoke(seriesId: Int): MarvelSeries {
        return seriesDetailsMapper.map( marvelRepository.getSeriesId(seriesId) )
    }
}