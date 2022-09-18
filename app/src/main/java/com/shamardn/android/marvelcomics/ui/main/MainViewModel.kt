package com.shamardn.android.marvelcomics.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shamardn.android.marvelcomics.HeroesInteractionListener
import com.shamardn.android.marvelcomics.data.State
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHero
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHeroResponse
import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.networking.ApiRequest
import com.shamardn.android.marvelcomics.utils.add
import com.shamardn.android.marvelcomics.utils.observeOnMainThread
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainViewModel : ViewModel(), HeroesInteractionListener{

    override fun onClickHero(hero: MarvelHero) {

    }

}