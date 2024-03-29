package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesDetailsUiState
import com.shamardn.android.marvelcomics.utils.Constants
import com.shamardn.android.marvelcomics.utils.formatDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarvelSeriesDetails(
    state: SeriesDetailsUiState,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onClickCharacters: (Int, Int) -> Unit,
    onClickComics: (Int, Int) -> Unit,
    onClickStories: (Int, Int) -> Unit,
    onClickTryAgain: () -> Unit,
) {
    if (state.isLoading) {
        LoadingView()

    } else if (state.isError) {
        ErrorView(onClickTryAgain)
    } else {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(251.dp)) {

                ComplexImage(img = img, height = 251)

                BackIcon(
                    modifier = Modifier.align(Alignment.TopStart), onBackClick,
                )

                SaveIcon(
                    modifier = Modifier.align(Alignment.TopEnd), onSaveClick,
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            ) {

                stickyHeader {
                    HeaderTitle(
                        title = state.title,
                        modifier = Modifier
                            .padding(top = 16.dp),
                    )
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "Modified year",
                        )

                        Text(
                            text = formatDate(state.modified),
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier,
                        )
                    }
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Card(
                            elevation = 0.dp,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .clip(shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp))
                        ) {
                            Text(
                                text = "Comics : ${state.comics.available}",
                                color = Color.White,
                                modifier = Modifier
                                    .background(color = Color.Red)
                                    .padding(8.dp)
                            )
                        }

                        Card(
                            elevation = 0.dp,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .clip(shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp))
                        ) {
                            Text(
                                text = "Characters : ${state.characters.available}",
                                color = Color.White,
                                modifier = Modifier
                                    .background(color = Color.Red)
                                    .padding(8.dp)
                            )
                        }

                        Card(
                            elevation = 0.dp,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .clip(shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp))
                        ) {
                            Text(
                                text = "Stories : ${state.stories.available}",
                                color = Color.White,
                                modifier = Modifier
                                    .background(color = Color.Red)
                                    .padding(8.dp)
                            )
                        }
                    }
                }

                stickyHeader {
                    SubTitle(
                        title = stringResource(id = R.string.desc),
                        modifier = Modifier
                            .padding(top = 16.dp),
                    )
                }

                item {
                    val description: String = state.description
                    if (description == "") {
                        HyperlinkText(fullText = stringResource(R.string.no_desc),
                            fontSize = 14.sp,
                            linkText = listOf("official website"),
                            hyperlinks = listOf("https://marvel.com/characters"))

                    } else {
                        Text(
                            text = description,
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier,
                        )
                    }
                }
                item {
                    ComicsCard(
                        title = stringResource(id = R.string.comics),
                        image = painterResource(id = R.drawable.series),
                        onClick = { onClickComics(state.id, Constants.SERIES_TYPE) },
                    )
                }

                item {
                    ComicsCard(
                        title = stringResource(id = R.string.characters),
                        image = painterResource(id = R.drawable.comics),
                        onClick = { onClickCharacters(state.id, Constants.SERIES_TYPE) },
                    )
                }

                item {
                    ComicsCard(
                        title = stringResource(id = R.string.stories),
                        image = painterResource(id = R.drawable.stories),
                        onClick = { onClickStories(state.id, Constants.SERIES_TYPE) },
                    )
                }

            }
        }
    }
}
