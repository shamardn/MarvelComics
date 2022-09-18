package com.shamardn.android.marvelcomics.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shamardn.android.marvelcomics.HeroesInteractionListener
import com.shamardn.android.marvelcomics.base.BaseViewModel
import com.shamardn.android.marvelcomics.data.State
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHero
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHeroResponse
import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.networking.ApiRequest
import com.shamardn.android.marvelcomics.utils.ClickEvent
import com.shamardn.android.marvelcomics.utils.add
import com.shamardn.android.marvelcomics.utils.observeOnMainThread

class HomeViewModel: BaseViewModel(), HeroesInteractionListener {

    private val repository = MarvelRepository(ApiRequest.apiService)

    private val _character = MutableLiveData<ClickEvent>()
    val character: LiveData<ClickEvent> get() = _character

    private val _currentHeroes = MutableLiveData<State<MarvelHeroResponse>?>()
    val currentHeroes: LiveData<State<MarvelHeroResponse>?>
        get() = _currentHeroes

    init {
        getHeroes()
    }

    private fun getHeroes() {
        repository.getHeroes().run {
            observeOnMainThread()
            subscribe(::onGetHeroesSuccess, ::onGetHeroesError)
        }.add(disposable)
    }

    private fun onGetHeroesSuccess(state: State<MarvelHeroResponse>) {
        _currentHeroes.postValue(state)
    }

    private fun onGetHeroesError(throwable: Throwable) {

    }

    override fun onClickHero(hero: MarvelHero) {
        _character.postValue(ClickEvent.OnNavigateToDetailsFragment(hero))
    }
}