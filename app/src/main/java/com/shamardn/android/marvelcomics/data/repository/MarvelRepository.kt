package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.State
import com.shamardn.android.marvelcomics.networking.MarvelApiService
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepository(private val service: MarvelApiService) : MarvelRepositoryInterface {
    override fun getHeroes() = wrapResponse(service.getMarvelHeroes())

    private fun <T> wrapResponse(response: Single<Response<T>>): Single<State<T>> {
        return response.map {
            try {
                State.Loading
                (if (it.isSuccessful) {
                    State.Success(it.body())
                } else {
                    State.Error(it.message())
                }) as State<T>
            } catch (e: Exception) {
                State.Error(e.message.toString())
            }
        }
    }
}


