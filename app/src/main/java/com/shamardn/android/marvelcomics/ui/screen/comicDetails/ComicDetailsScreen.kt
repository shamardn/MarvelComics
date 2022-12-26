package com.shamardn.android.marvelcomics.ui.screen.comicDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelComicDetails
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState

@Composable
fun ComicDetailsScreen(
    navController: NavController,
    viewModel: ComicDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    ComicContent(
        state = state,
        onBackClick = { navController.popBackStack() },
        onClickCharacter = { id -> navController.navigate("${Screen.Characters.route}/$id")},
        onClickSeries = { id -> navController.navigate("${Screen.Series.route}/$id")},
    )
}

@Composable
fun ComicContent(
    state: ComicDetailsUiState,
    onBackClick: () -> Unit,
    onClickCharacter: (Int) -> Unit,
    onClickSeries: (Int) -> Unit,
) {
    MarvelComicDetails(
        state = state,
        onBackClick = onBackClick,
        onClickCharacter = onClickCharacter,
        onClickSeries = onClickSeries,
    )
}