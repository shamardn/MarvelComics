package com.shamardn.android.marvelcomics

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shamardn.android.marvelcomics.ui.screen.comicDetails.ComicDetailsScreen
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.CharacterDetailsScreen
import com.shamardn.android.marvelcomics.ui.screen.characters.CharactersScreen
import com.shamardn.android.marvelcomics.ui.screen.comics.ComicsScreen
import com.shamardn.android.marvelcomics.ui.screen.home.HomeScreen
import com.shamardn.android.marvelcomics.ui.screen.series.SeriesScreen
import com.shamardn.android.marvelcomics.ui.screen.seriesDetails.SeriesDetailsScreen

@Composable
fun MarvelNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) { HomeScreen(navController) }

        composable("${Screen.Characters.route}/{id}/{idType}",
            arguments = listOf(
                navArgument(name = "id") { NavType.IntType},
                navArgument(name = "idType") { NavType.IntType},
            ))
        { CharactersScreen(navController) }

        composable("${Screen.CharacterDetails.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType }, ))
        { CharacterDetailsScreen(navController) }


        composable("${Screen.Comics.route}/{id}/{idType}",
            arguments = listOf
                (navArgument(name = "id") { NavType.IntType},
                navArgument(name = "idType") { NavType.IntType},
            ))
        { ComicsScreen(navController) }


        composable("${Screen.ComicDetails.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType}, ))
        { ComicDetailsScreen(navController) }

        composable("${Screen.Series.route}/{id}/{idType}",
            arguments = listOf(
                navArgument(name = "id") { NavType.IntType},
                navArgument(name = "idType") { NavType.IntType},
            ))
        { SeriesScreen(navController) }

        composable("${Screen.SeriesDetails.route}/{id}",
            arguments = listOf(navArgument(name = "id") { NavType.IntType}, ))
        { SeriesDetailsScreen(navController) }
    }
}
