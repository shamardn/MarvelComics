package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.HeaderTitle
import com.shamardn.android.marvelcomics.ui.composable.ItemCharacter
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.CharactersUiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state,
        onClickCharacter = { id ->
            navController.navigate(route = "${Screen.Character.route}/$id")
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: CharactersUiState,
    onClickCharacter: (Int) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(vertical = 16.dp)
    ){
        stickyHeader {
            HeaderTitle(title = "Characters")
        }
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)) {
                items(
                    items = state.marvelCharacters,
                    key = { currentCharacter ->
                        currentCharacter.name
                    }
                ) {
                    ItemCharacter(state = it,
                        onClick = { onClickCharacter(it.id) },
                        modifier = Modifier
                            .animateItemPlacement()
                    )
                }
            }
        }
    }



}