package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO

interface MarvelRepository {
    // Character
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharactersByComicId(comicId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharactersBySeriesId(seriesId: Int): BaseResponse<MarvelCharacterDTO>

    // comic
    suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO>

    suspend fun getComicId(comicId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsByCharacterId(characterId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsBySeriesId(seriesId: Int): BaseResponse<MarvelComicDTO>

    // series
    suspend fun getMarvelSeries(): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesId(seriesId: Int): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesByCharacterId(characterId: Int): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesByComicId(comicId: Int): BaseResponse<MarvelSeriesDTO>
}