package com.shamardn.android.marvelcomics.ui.screen.comics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import com.shamardn.android.marvelcomics.ui.composable.ErrorView
import com.shamardn.android.marvelcomics.ui.composable.ImageForEmptyList
import com.shamardn.android.marvelcomics.ui.composable.ItemComic
import com.shamardn.android.marvelcomics.ui.composable.LoadingView
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicsUiState

@Composable
fun ComicsScreen(
    navController: NavHostController,
    viewModel: ComicsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    ComicsContent(state = state,
        onBackClick = { navController.navigateUp() },
        onClickComic = { id ->
            navController.navigate(route = "${Screen.ComicDetails.route}/$id")
        },
        onClickTryAgain = viewModel::onClickTryAgain,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ComicsContent(
    state: ComicsUiState,
    onBackClick: () -> Unit,
    onClickComic: (Int) -> Unit,
    onClickTryAgain: () -> Unit,
) {
    val isEmptyList = state.marvelComics.isEmpty()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.comics),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.desc)
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->
            if (state.isLoading) {
                LoadingView()

            } else if (state.isError) {
                ErrorView(onClickTryAgain)
            } else {
                if (isEmptyList && state.isLoading.not()) {
                    ImageForEmptyList(modifier = Modifier
                        .fillMaxSize()
                    )
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 128.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(16.dp),
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        items(
                            items = state.marvelComics,
                        ) {
                            ItemComic(
                                state = it,
                                onClickComic = { onClickComic(it.id) },
                            )
                        }
                    }
                }
            }
        }
    )
}