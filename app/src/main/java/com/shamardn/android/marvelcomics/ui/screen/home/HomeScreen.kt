@file:OptIn(ExperimentalFoundationApi::class)

package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.Screen
import com.shamardn.android.marvelcomics.ui.composable.*
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.HomeUiState
import com.shamardn.android.marvelcomics.ui.theme.Gray200
import kotlin.math.absoluteValue

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
        },
        onClickSeries = { id ->
            navController.navigate(route = "${Screen.SeriesDetails.route}/$id")
        },
        onClickStory = { id ->
            navController.navigate(route = "${Screen.StoryDetails.route}/$id")
        },
        onClickTryAgain = viewModel::onClickTryAgain,


    )
}

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalPagerApi::class,
    ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    onClickCharacter: (Int) -> Unit,
    onClickComic: (Int) -> Unit,
    onClickSeries: (Int) -> Unit,
    onClickStory: (Int) -> Unit,
    onClickTryAgain: () -> Unit = {},
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(title = {
            Text(
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

        if (state.isLoading) {
            LoadingView()

        } else if (state.isError ) {
            ErrorView(onClickTryAgain)
        } else {
            LazyColumn(verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                contentPadding = PaddingValues(vertical = 16.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .background(color = Gray200)
            ) {

                item {
                    val items = state.marvelCharacters
                    val pagerState = rememberPagerState()
                    HorizontalPager(
                        count = items.size,
                        state = pagerState,
                        contentPadding = PaddingValues(horizontal = 32.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) { currentPage  ->
                        Card(
                            Modifier
                                .height(300.dp)
                                .width(250.dp)
                                .clip(CutCornerShape(bottomEnd = 16.dp))
                                .graphicsLayer {

                                    val pageOffset = calculateCurrentOffsetForPage(currentPage).absoluteValue

                                    lerp(
                                        start = 0f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    ).also { scale ->
                                        scaleX = scale
                                        scaleY = scale
                                    }

                                    alpha = lerp(
                                        start = 0.5f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                }
                        ) {
                            BigItemCharacter(state = items[currentPage],
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
                        )

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

                stickyHeader {
                    Text(text = stringResource(R.string.series),
                        color = Color.Red,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .fillMaxWidth()
                    )

                }
                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)) {
                        items(
                            items = state.marvelSeries,
                        ) {
                            ItemSeries(state = it,
                                onClickSeries = { onClickSeries(it.id) }
                            )
                        }
                    }
                }

                stickyHeader {
                    Text(text = stringResource(R.string.stories),
                        color = Color.Red,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .fillMaxWidth()
                    )

                }
                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)) {
                        items(
                            items = state.marvelStories,
                        ) {
                            ItemStory(state = it,
                                onClickStory = { onClickStory(it.id) }
                            )
                        }
                    }
                }

            }
        }

    })
}