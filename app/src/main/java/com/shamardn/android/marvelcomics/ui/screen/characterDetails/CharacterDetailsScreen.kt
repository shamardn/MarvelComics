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
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    CharacterContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) },
        onClickComics = { id, idType -> navController.navigate("${Screen.Comics.route}/$id/$idType")},
        onClickSeries = { id, idType -> navController.navigate("${Screen.Series.route}/$id/$idType")},
        onClickStories = { id, idType -> navController.navigate("${Screen.Stories.route}/$id/$idType")},
        onClickTryAgain = viewModel::onClickTryAgain,
    )
}

@Composable
fun CharacterContent(
    state: CharacterDetailsUiState,
    onBackClick: () -> Unit,
    onClickComics: (Int, Int) -> Unit,
    onClickSeries: (Int, Int) -> Unit,
    onClickStories: (Int, Int) -> Unit,
    onClickTryAgain: () -> Unit,
) {
    MarvelCharacterDetails(
        state = state,
        onBackClick = onBackClick,
        onSaveClick = {},
        onClickComics = onClickComics,
        onClickSeries = onClickSeries,
        onClickStories = onClickStories,
        onClickTryAgain = onClickTryAgain,
    )
}