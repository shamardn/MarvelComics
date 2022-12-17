package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.ItemCharacter
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state,
        onClickCharacter = { currentCharacter ->
            navController.currentBackStackEntry?.savedStateHandle?.set(
                key = Screen.Character.route,
                value = currentCharacter,
            )
            navController.navigate(route = Screen.Character.route)}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: CharactersUiState,
    onClickCharacter: (CharactersDetailsUiState) -> Unit,
) {
    LazyVerticalGrid(
           columns = GridCells.Adaptive(minSize = 128.dp),
           verticalArrangement = Arrangement.spacedBy(16.dp),
           horizontalArrangement = Arrangement.spacedBy(16.dp),
           contentPadding = PaddingValues(16.dp),
           ){
        headerSpan {
            HeaderTitle("Characters")
        }

           items(
               items = state.marvelCharacters,
               key = { currentCharacter ->
                   currentCharacter.name
               }
           ) {
               ItemCharacter(
                   state = it,
                   onClick = { onClickCharacter(it) },
                   modifier = Modifier.animateItemPlacement()
               )
           }
       }
}

@Composable
fun HeaderTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(8.dp)

    )
}

fun LazyGridScope.headerSpan(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}