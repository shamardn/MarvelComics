package com.shamardn.android.marvelcomics

sealed class Screen(val route: String){
    object Home: Screen("home")
    object CharacterDetails: Screen("characterDetails")
    object ComicDetails: Screen("comicDetails")
    object Comics: Screen("comics")
    object Series: Screen("series")
}
