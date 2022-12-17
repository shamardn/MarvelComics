package com.shamardn.android.marvelcomics.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shamardn.android.marvelcomics.MarvelNavGraph
import com.shamardn.android.marvelcomics.ui.theme.SocialNetworkTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MarvelComicsApp() {
    SocialNetworkTheme {
        Scaffold {
            val navController = rememberNavController()
            MarvelNavGraph(navController = navController)
        }
    }
}