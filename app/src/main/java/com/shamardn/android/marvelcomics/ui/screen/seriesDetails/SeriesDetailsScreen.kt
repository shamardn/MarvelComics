package com.shamardn.android.marvelcomics.ui.screen.seriesDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelSeriesDetails
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesDetailsUiState

@Composable
fun SeriesDetailsScreen(
    navController: NavController,
    viewModel: SeriesDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    SeriesContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) },
        onSaveClick = {  },
        onClickCharacters = { id, idType -> navController.navigate("${Screen.Characters.route}/$id/$idType")},
        onClickComics = { id, idType -> navController.navigate("${Screen.Comics.route}/$id/$idType")},
        onClickStories = { id, idType -> navController.navigate("${Screen.Stories.route}/$id/$idType")},
    )
}

@Composable
fun SeriesContent(
    state: SeriesDetailsUiState,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onClickCharacters: (Int, Int) -> Unit,
    onClickComics: (Int, Int) -> Unit,
    onClickStories: (Int, Int) -> Unit,
) {
    MarvelSeriesDetails(
        state = state,
        onBackClick = onBackClick,
        onSaveClick = onSaveClick,
        onClickCharacters = onClickCharacters,
        onClickComics = onClickComics,
        onClickStories = onClickStories,
    )
}