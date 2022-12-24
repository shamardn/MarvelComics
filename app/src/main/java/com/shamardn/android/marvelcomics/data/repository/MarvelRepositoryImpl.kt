package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.service.MarvelService
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val marvelService: MarvelService
    ) : MarvelRepository {

    override suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO> {
       return marvelService.getMarvelCharacters()
    }

    override suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO> {
        return marvelService.getMarvelComics()
    }

    override suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO> {
        return marvelService.getCharacterId(characterId)
    }

    override suspend fun getComicId(comicId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicId(comicId)
    }

    override suspend fun getComicsByCharacterId(characterId: Int): BaseResponse<MarvelComicDTO> {
        return marvelService.getComicsByCharacterId(characterId)
    }
}


