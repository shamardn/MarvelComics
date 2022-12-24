package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.ItemCharacter
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState

@Composable
fun CharactersScreen(
    navController: NavHostController,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    CharactersContent(state = state,
        onBackClick = { navController.navigateUp() },
        onClickCharacter = { id ->
            navController.navigate(route = "${Screen.CharacterDetails.route}/$id")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CharactersContent(
    state: CharactersUiState,
    onBackClick: () -> Unit,
    onClickCharacter: (Int) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                       text = stringResource(R.string.characters),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack ,
                            contentDescription = stringResource(id = R.string.desc)
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.padding(innerPadding)
            ){
                items(
                    items = state.marvelCharacters,
                    key = { currentCharacters ->
                        currentCharacters.name
                    }
                ) {
                    ItemCharacter(
                        state = it,
                        onClickCharacter = { onClickCharacter(it.id) },
                    )
                }
            }
        }
    )
}