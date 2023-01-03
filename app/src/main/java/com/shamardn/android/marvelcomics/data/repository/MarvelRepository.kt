package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelStoryDTO

interface MarvelRepository {

    //region Character
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharactersByComicId(comicId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharactersBySeriesId(seriesId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharactersByStoryId(storyId: Int): BaseResponse<MarvelCharacterDTO>

    //endregion

    //region comic
    suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO>

    suspend fun getComicId(comicId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsByCharacterId(characterId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsBySeriesId(seriesId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsByStoryId(storyId: Int): BaseResponse<MarvelComicDTO>

    //endregion

    //region series
    suspend fun getMarvelSeries(): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesId(seriesId: Int): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesByCharacterId(characterId: Int): BaseResponse<MarvelSeriesDTO>

    suspend fun getSeriesByStoryId(storyId: Int): BaseResponse<MarvelSeriesDTO>

    //endregion

    //region stories

    suspend fun getMarvelStories(): BaseResponse<MarvelStoryDTO>

    suspend fun getStoriesByCharacterId(characterId: Int): BaseResponse<MarvelStoryDTO>

    suspend fun getStoriesBySeriesId(seriesId: Int): BaseResponse<MarvelStoryDTO>

    suspend fun getStoriesByComicId(comicId: Int): BaseResponse<MarvelStoryDTO>

    suspend fun getStoryDetailsById(storyId: Int): BaseResponse<MarvelStoryDTO>

    //endregion
}