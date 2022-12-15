package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarvelDetails(
    state: CharactersUiState,
    onBackClick: () -> Unit,
    onClickCharacter: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.ic_onboarding),
                contentDescription = "Description",
                modifier = Modifier
                    .fillMaxSize(),
                )

            BackIcon(
                modifier = Modifier.align(Alignment.TopStart),
                onBackClick,
            )
        }
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.fake_name),
                color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.h5,
                modifier = Modifier,
            )

            Text(
                text = stringResource(R.string.date),
                color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.caption,
                modifier = Modifier,
            )
        }

        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.desc),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier,

                )
            Text(
                text = stringResource(R.string.more),
                color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .clickable { onBackClick() },
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier,
        ) {
            item {
                Text(
                    text = stringResource(R.string.comics),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp),
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp),
                ) {
                    items(items = state.marvelCharacters,
                        key = { currentCharacter ->
                            currentCharacter.name
                        }
                        ){
                        ItemComic(
                            state = it,
                            onClick = { onClickCharacter() },
                            modifier = Modifier.animateItemPlacement()
                                .size(150.dp,100.dp)
                        )
                    }

                }
            }
        }

    }
}
