package com.shamardn.android.marvelcomics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shamardn.android.marvelcomics.ui.screen.characters.CharacterScreen
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.home.HomeScreen

@Composable
fun MarvelNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route){
    composable(Screen.Home.route){ HomeScreen(navController) }
    composable(Screen.Character.route){
        LaunchedEffect(key1 = it){
            navController.previousBackStackEntry?.savedStateHandle?.get<CharactersDetailsUiState>(Screen.Character.route)
        }
         CharacterScreen(navController)
    }

    }
}