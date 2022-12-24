package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO

interface MarvelRepository {
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO>

    suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO>

    suspend fun getComicId(comicId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getComicsByCharacterId(characterId: Int): BaseResponse<MarvelComicDTO>

    suspend fun getCharactersByComicId(comicId: Int): BaseResponse<MarvelCharacterDTO>
}