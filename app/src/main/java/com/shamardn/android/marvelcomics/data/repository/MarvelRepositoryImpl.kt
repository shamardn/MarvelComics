package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.data.remote.service.MarvelService
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val marvelService: MarvelService
    ) : MarvelRepository {

    //region Character
    override suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO> {
       return marvelService.getMarvelCharacters()
    }

    override suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO> {
        return marvelService.getCharacterId(characterId)
    }

    override suspend fun getCharactersByComicId(comicId: Int): BaseResponse<MarvelCharacterDTO> {
        return marvelService.getCharactersByComicId(comicId)
    }

    override suspend fun getCharactersBySeriesId(seriesId: Int): BaseResponse<MarvelCharacterDTO> {
        return marvelService.getCharactersBySeriesId(seriesId)
    }

    //endregion

    //region Comic
    override suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO> {
        return marvelService.getMarvelComics()
    }

    override suspend fun getComicId(comicId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicId(comicId)
    }

    override suspend fun getComicsByCharacterId(characterId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicsByCharacterId(characterId)
    }

    override suspend fun getComicsBySeriesId(seriesId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicsBySeriesId(seriesId)
    }

    //endregion

    //region Series
    override suspend fun getMarvelSeries(): BaseResponse<MarvelSeriesDTO> {
        return marvelService.getMarvelSeries()
    }

    override suspend fun getSeriesId(seriesId: Int): BaseResponse<MarvelSeriesDTO> {
        return marvelService.getSeriesId(seriesId)
    }

    override suspend fun getSeriesByCharacterId(characterId: Int): BaseResponse<MarvelSeriesDTO> {
        return marvelService.getSeriesByCharacterId(characterId)
    }

    override suspend fun getSeriesByComicId(comicId: Int): BaseResponse<MarvelSeriesDTO> {
        return marvelService.getSeriesByComicId(comicId)
    }
    //endregion
}


