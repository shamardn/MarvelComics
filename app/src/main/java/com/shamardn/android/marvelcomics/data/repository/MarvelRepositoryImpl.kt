package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelStoryDTO
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

    override suspend fun getCharactersByStoryId(storyId: Int): BaseResponse<MarvelCharacterDTO> {
        return marvelService.getCharactersByStoryId(storyId)
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

    override suspend fun getComicsByStoryId(storyId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicsByStoryId(storyId)
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

    override suspend fun getSeriesByStoryId(storyId: Int): BaseResponse<MarvelSeriesDTO> {
        return marvelService.getSeriesByStoryId(storyId)
    }

    //endregion

    // region Stories
    override suspend fun getMarvelStories(): BaseResponse<MarvelStoryDTO> {
        return marvelService.getMarvelStories()
    }

    override suspend fun getStoryDetailsById(storyId: Int): BaseResponse<MarvelStoryDTO> {
        return marvelService.getStoryDetailsById(storyId)
    }

    override suspend fun getStoriesByCharacterId(characterId: Int): BaseResponse<MarvelStoryDTO> {
        return marvelService.getStoriesByCharacterId(characterId)
    }

    override suspend fun getStoriesBySeriesId(seriesId: Int): BaseResponse<MarvelStoryDTO> {
        return marvelService.getStoriesBySeriesId(seriesId)
    }

    override suspend fun getStoriesByComicId(comicId: Int): BaseResponse<MarvelStoryDTO> {
        return marvelService.getStoriesByComicId(comicId)
    }

    //endregion
}


