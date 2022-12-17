package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelDetails
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    val currentCharacter =
        navController.previousBackStackEntry?.savedStateHandle?.get<CharactersDetailsUiState>(Screen.Character.route)

    CharacterContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) }
    )

    if (currentCharacter != null) {
        viewModel.updateCurrentCharacter(currentCharacter)
    }
}

@Composable
fun CharacterContent(
    state: CharactersDetailsUiState,
    onBackClick: () -> Unit,
) {
    MarvelDetails(
        state = state,
        onBackClick,
    )
}