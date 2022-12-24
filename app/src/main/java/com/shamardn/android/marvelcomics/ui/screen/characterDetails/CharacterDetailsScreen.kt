package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelCharacterDetails
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    CharacterContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) },
        onClickComics = { id -> navController.navigate("${Screen.Comics.route}/$id")},
//        onClickSeries = { id -> navController.navigate("${Screen.Series.route}/$id")},
    )
}

@Composable
fun CharacterContent(
    state: CharacterDetailsUiState,
    onBackClick: () -> Unit,
    onClickComics: (Int) -> Unit,
//    onClickSeries: (Int) -> Unit,
) {
    MarvelCharacterDetails(
        state = state,
        onBackClick = onBackClick,
        onClickComics = onClickComics,
//        onClickSeries = onClickSeries,
    )
}