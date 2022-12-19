package com.shamardn.android.marvelcomics.data.remote.service

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("characters")
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    @GET("characters/{characterId}")
    suspend fun getCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelCharacterDTO>
}