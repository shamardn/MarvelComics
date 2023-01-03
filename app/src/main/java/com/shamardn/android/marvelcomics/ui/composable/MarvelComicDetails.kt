package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState
import com.shamardn.android.marvelcomics.utils.Constants
import com.shamardn.android.marvelcomics.utils.formatDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarvelComicDetails(
    state: ComicDetailsUiState,
    onBackClick: () -> Unit,
    onClickCharacter: (Int, Int) -> Unit,
    onClickSeries: (Int, Int) -> Unit,
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
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)) {

                val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
                ComplexImage(img = img, height = 210)

                BackIcon(
                    modifier = Modifier.align(Alignment.TopStart), onBackClick,
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            ) {

                stickyHeader {
                    HeaderTitle(title = state.title)
                }

                item {
                    Text(
                        text = formatDate(state.modified),
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier,
                    )
                }

                item {
                    Card(
                        contentColor = Color.Red,
                        elevation = 0.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(width = 2.dp,
                                color = Color.Red,
                                shape = RoundedCornerShape(16.dp))
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                        ) {
                            Text(text = "Characters", modifier = Modifier.padding(vertical = 16.dp))
                            Text(text = state.characters.available.toString())
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Series")
                            Text(text = state.series.available.toString())
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Stories")
                            Text(text = state.stories.available.toString())
                        }
                    }
                }

                item {
                    val description: String = state.description
                    if (description == "") {
                        HyperlinkText(fullText = stringResource(R.string.no_desc),
                            fontSize = 14.sp,
                            linkText = listOf("official website"),
                            hyperlinks = listOf("https://marvel.com/comics"))

                    } else {
                        Text(
                            text = description,
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier,
                        )
                    }
                }
                stickyHeader {
                    HeaderTitle(title = stringResource(id = R.string.characters))
                }

                item {
                    Card(
                        modifier = Modifier
                            .clickable { onClickCharacter(state.id, Constants.COMIC_TYPE) }
                            .fillMaxWidth()
                            .height(130.dp)
                            .border(width = 2.dp,
                                color = Color.Yellow,
                                shape = RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        elevation = 0.dp,
                        backgroundColor = Color.LightGray,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.comics),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "Characters",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

                stickyHeader {
                    HeaderTitle(title = stringResource(R.string.series))
                }

                item {
                    Card(
                        modifier = Modifier
                            .clickable { onClickSeries(state.id, Constants.COMIC_TYPE) }
                            .fillMaxWidth()
                            .height(130.dp)
                            .border(width = 2.dp,
                                color = Color.Yellow,
                                shape = RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        elevation = 0.dp,
                        backgroundColor = Color.LightGray

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.series),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "series",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

                stickyHeader {
                    HeaderTitle(title = stringResource(R.string.stories))
                }

                item {
                    Card(
                        modifier = Modifier
                            .clickable { onClickStories(state.id, Constants.COMIC_TYPE) }
                            .padding(bottom = 16.dp)
                            .fillMaxWidth()
                            .height(130.dp)
                            .border(width = 2.dp,
                                color = Color.Yellow,
                                shape = RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        elevation = 0.dp,
                        backgroundColor = Color.LightGray
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.stories),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "stories",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}
