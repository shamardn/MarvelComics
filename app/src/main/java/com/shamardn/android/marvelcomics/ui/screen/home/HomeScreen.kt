package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.ItemCharacter
import com.shamardn.android.marvelcomics.ui.composable.ItemComic
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.HomeUiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state = state,
        onClickCharacter = { id ->
        navController.navigate(route = "${Screen.CharacterDetails.route}/$id")
    },
        onClickComic = { id ->
            navController.navigate(route = "${Screen.ComicDetails.route}/$id")
        }
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    onClickCharacter: (Int) -> Unit,
    onClickComic: (Int) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(title = {
            androidx.compose.material3.Text(
                "Marvel Comics",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }, navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Localized description")
            }
        }, scrollBehavior = scrollBehavior)
    }, content = { innerPadding ->
        LazyColumn(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            contentPadding = PaddingValues(vertical = 16.dp),
            modifier = Modifier.padding(innerPadding)
        ) {

            stickyHeader {
                Text(text = stringResource(R.string.characters),
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .background(color = Color.White))

            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)) {
                    items(items = state.marvelCharacters, key = { character ->
                        character.name
                    }) {
                        ItemCharacter(state = it,
                            onClickCharacter = { onClickCharacter(it.id) }
                        )
                    }
                }
            }

            stickyHeader {
                Text(text = stringResource(R.string.comics),
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .fillMaxWidth()
                        .background(color = Color.White))

            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)) {
                    items(
                        items = state.marvelComics,
                ) {
                        ItemComic(state = it,
                            onClickComic = { onClickComic(it.id) }
                        )
                    }
                }
            }

        }
    })
}