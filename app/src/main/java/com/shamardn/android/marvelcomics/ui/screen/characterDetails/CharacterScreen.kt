package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelDetails
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    CharacterContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) }
    )

}

@Composable
fun CharacterContent(
    state: CharacterDetailsUiState,
    onBackClick: () -> Unit,
) {
    MarvelDetails(
        state = state,
        onBackClick = onBackClick,
        onClickComic = {},
    )
}