package com.shamardn.android.marvelcomics.data.remote.service

import com.shamardn.android.marvelcomics.data.remote.response.base.BaseResponse
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelCharacterDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelComicDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelSeriesDTO
import com.shamardn.android.marvelcomics.data.remote.response.dto.MarvelStoryDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    //region Character
    @GET("characters")
    suspend fun getMarvelCharacters(): BaseResponse<MarvelCharacterDTO>

    @GET("characters/{characterId}")
    suspend fun getCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelCharacterDTO>

    @GET("comics/{comicId}/characters")
    suspend fun getCharactersByComicId(
        @Path("comicId") comicId: Int,
    ): BaseResponse<MarvelCharacterDTO>

    @GET("series/{seriesId}/characters")
    suspend fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int,
    ): BaseResponse<MarvelCharacterDTO>

    @GET("stories/{storyId}/characters")
    suspend fun getCharactersByStoryId(
        @Path("storyId") storyId: Int,
    ): BaseResponse<MarvelCharacterDTO>

    //endregion

    //region Comic
    @GET("comics")
    suspend fun getMarvelComics(): BaseResponse<MarvelComicDTO>

    @GET("comics/{comicId}")
    suspend fun getComicId(
        @Path("comicId") comicId: Int,
    ): BaseResponse<MarvelComicDTO>

    @GET("characters/{characterId}/comics")
    suspend fun getComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelComicDTO>

    @GET("series/{seriesId}/comics")
    suspend fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int,
    ): BaseResponse<MarvelComicDTO>

    @GET("stories/{storyId}/comics")
    suspend fun getComicsByStoryId(
        @Path("storyId") storyId: Int,
    ): BaseResponse<MarvelComicDTO>

    //endregion

    //region Series
    @GET("series")
    suspend fun getMarvelSeries(): BaseResponse<MarvelSeriesDTO>

    @GET("series/{seriesId}")
    suspend fun getSeriesId(
        @Path("seriesId") seriesId: Int,
    ): BaseResponse<MarvelSeriesDTO>

    @GET("characters/{characterId}/series")
    suspend fun getSeriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelSeriesDTO>

    @GET("stories/{storyId}/series")
    suspend fun getSeriesByStoryId(
        @Path("storyId") storyId: Int,
    ): BaseResponse<MarvelSeriesDTO>

    //endregion

    //region Stories

    @GET("stories")
    suspend fun getMarvelStories(): BaseResponse<MarvelStoryDTO>

    @GET("characters/{characterId}/stories")
    suspend fun getStoriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): BaseResponse<MarvelStoryDTO>

    @GET("series/{seriesId}/stories")
    suspend fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int,
    ): BaseResponse<MarvelStoryDTO>


    @GET("comics/{comicId}/stories")
    suspend fun getStoriesByComicId(
        @Path("comicId") comicId: Int,
    ): BaseResponse<MarvelStoryDTO>

    @GET("stories/{storyId}")
    suspend fun getStoryDetailsById(
        @Path("storyId") storyId: Int,
    ): BaseResponse<MarvelStoryDTO>

    //endregion
}