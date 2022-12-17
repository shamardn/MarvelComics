package com.shamardn.android.marvelcomics

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Character: Screen("character")
}
