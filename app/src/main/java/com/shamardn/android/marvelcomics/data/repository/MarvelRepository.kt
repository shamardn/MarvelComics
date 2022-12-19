package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO

interface MarvelRepository {
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    suspend fun getCharacterId(characterId: Int): BaseResponse<MarvelCharacterDTO>
}