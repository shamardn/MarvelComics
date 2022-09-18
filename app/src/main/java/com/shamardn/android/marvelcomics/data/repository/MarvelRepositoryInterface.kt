package com.shamardn.android.marvelcomics.data.repository

import com.shamardn.android.marvelcomics.data.State
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHeroResponse
import io.reactivex.rxjava3.core.Single

interface MarvelRepositoryInterface {
    fun getHeroes(): Single<State<MarvelHeroResponse>>
}