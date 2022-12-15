package com.shamardn.android.marvelcomics.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shamardn.android.marvelcomics.ui.screen.characters.CharacterScreen
import com.shamardn.android.marvelcomics.ui.screen.home.HomeScreen
import com.shamardn.android.marvelcomics.ui.theme.SocialNetworkTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MarvelComicsApp() {
    SocialNetworkTheme {
        Scaffold {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home" ){
                composable("home"){ HomeScreen(navController)}
                composable("character"){ CharacterScreen(navController) }
            }
        }
    }

}