package com.shamardn.android.marvelcomics

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shamardn.android.marvelcomics.ui.screen.comicDetails.ComicDetailsScreen
import com.shamardn.android.marvelcomics.ui.screen.SeriesScreen
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.CharacterDetailsScreen
import com.shamardn.android.marvelcomics.ui.screen.comics.ComicsScreen
import com.shamardn.android.marvelcomics.ui.screen.home.HomeScreen

@Composable
fun MarvelNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) { HomeScreen(navController) }

        composable("${Screen.CharacterDetails.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType }, ))
        { CharacterDetailsScreen(navController) }

        composable("${Screen.Comics.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType}, ))
        { ComicsScreen(navController) }

        composable("${Screen.ComicDetails.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType}, ))
        { ComicDetailsScreen(navController) }

        composable("${Screen.Series.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType}, ))
        { SeriesScreen(navController) }
    }
}
