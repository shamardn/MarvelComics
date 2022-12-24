package com.shamardn.android.marvelcomics.data.remote.service

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("characters")
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    @GET("comics")
    suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO>

    @GET("characters/{characterId}")
    suspend fun getCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelCharacterDTO>

    @GET("comics/{comicId}")
    suspend fun getComicId(
        @Path("comicId") comicId: Int,
    ): BaseResponse<MarvelComicDTO>

    @GET("characters/{characterId}/comics")
    suspend fun getComicsByCharacterId(
        @Path("characterId") characterId: Int
    ): BaseResponse<MarvelComicDTO>
}