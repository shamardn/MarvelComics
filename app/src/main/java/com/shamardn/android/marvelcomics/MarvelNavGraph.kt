package com.shamardn.android.marvelcomics

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.CharacterScreen
import com.shamardn.android.marvelcomics.ui.screen.home.HomeScreen

@Composable
fun MarvelNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable("${Screen.Character.route}/{id}",
            arguments = listOf(
                navArgument(name = "id") { NavType.IntType },
            )
        ) { CharacterScreen(navController) }
    }
}