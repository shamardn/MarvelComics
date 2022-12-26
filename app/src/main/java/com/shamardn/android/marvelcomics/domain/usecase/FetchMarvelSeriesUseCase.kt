package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.SeriesMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelSeries
import javax.inject.Inject

class FetchMarvelSeriesUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val seriesMapper: SeriesMapper,
){
     suspend operator fun invoke(): List<MarvelSeries> {
         return seriesMapper.map(marvelRepository.getMarvelSeries())
    }
}
