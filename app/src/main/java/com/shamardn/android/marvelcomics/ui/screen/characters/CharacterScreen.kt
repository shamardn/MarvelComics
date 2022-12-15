package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.ui.composable.MarvelDetails
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CharacterContent(
        state = state,
        onClickCharacter = viewModel::onClickCharacter,
        onBackClick = { navController.popBackStack("home", false)}
    )
}

@Composable
fun CharacterContent(

    state: CharactersUiState,
    onClickCharacter : () -> Unit,
    onBackClick: () -> Unit,
) {
    MarvelDetails(state = state, onBackClick, onClickCharacter)
}