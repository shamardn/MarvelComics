package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.ui.composable.ItemCharacter
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state,
//        onClickCharacter = viewModel::onClickCharacter
        onClickCharacter = { navController.navigate("character")}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: CharactersUiState,
//    onClickCharacter: (CharactersDetailsUiState) -> Unit,
    onClickCharacter: () -> Unit,
) {
    LazyVerticalGrid(
           columns = GridCells.Adaptive(minSize = 128.dp),
           verticalArrangement = Arrangement.spacedBy(16.dp),
           horizontalArrangement = Arrangement.spacedBy(16.dp),
           contentPadding = PaddingValues(16.dp),
           ){
           items(
               items = state.marvelCharacters,
               key = { currentCharacter ->
                   currentCharacter.name
               }
           ) {
               ItemCharacter(
                   state = it,
                   onClick = { onClickCharacter() },
                   modifier = Modifier.animateItemPlacement()
               )
           }
       }
}