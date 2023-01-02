package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.MarvelStoryDetails
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoryDetailsUiState

@Composable
fun StoryDetailsScreen(
    navController: NavController,
    viewModel: StoryDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    StoryContent(
        state = state,
        onBackClick = { navController.popBackStack(Screen.Home.route, false) },
        onClickComics = { id, idType -> navController.navigate("${Screen.Comics.route}/$id/$idType")},
        onClickSeries = { id, idType -> navController.navigate("${Screen.Series.route}/$id/$idType")},
        onClickCharacters = { id, idType -> navController.navigate("${Screen.Characters.route}/$id/$idType")},
    )
}

@Composable
fun StoryContent(
    state: StoryDetailsUiState,
    onBackClick: () -> Unit,
    onClickComics: (Int, Int) -> Unit,
    onClickSeries: (Int, Int) -> Unit,
    onClickCharacters: (Int, Int) -> Unit,
) {
    MarvelStoryDetails(
        state = state,
        onBackClick = onBackClick,
        onSaveClick = {},
        onClickComics = onClickComics,
        onClickSeries = onClickSeries,
        onClickCharacters = onClickCharacters,
    )
}