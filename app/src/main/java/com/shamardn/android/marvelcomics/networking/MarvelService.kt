package com.shamardn.android.marvelcomics.networking

import com.shamardn.android.marvelcomics.data.model.hero.MarvelHeroResponse
import com.shamardn.android.marvelcomics.utils.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
//    @GET("comics")
//    fun getComicsResponse(
//        @Query("ts") timeStamp: String = Constants.ts,
//        @Query("apikey") apiKey: String = Constants.API_KEY,
//        @Query("hash") hash: String = Constants.hash(),
//    ): Single<Response<MarvelComicsData>>


    @GET("characters")
    fun getMarvelHeroes(
        @Query("ts") timeStamp: String = Constants.ts,
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("hash") hash: String = Constants.hash(),
    ): Single<Response<MarvelHeroResponse>>
}