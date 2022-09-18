package com.shamardn.android.marvelcomics.utils

import com.shamardn.android.marvelcomics.data.model.hero.MarvelHero

sealed class ClickEvent{
    data class OnNavigateToDetailsFragment(val hero: MarvelHero): ClickEvent()
}
