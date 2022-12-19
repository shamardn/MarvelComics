package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState

@Composable
fun MarvelDetails(
    state: CharacterDetailsUiState,
    onBackClick: () -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)) {
            val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
            Image(
                painter = rememberAsyncImagePainter(model = img),
                contentDescription = "Description",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )

            BackIcon(
                modifier = Modifier.align(Alignment.TopStart), onBackClick,
            )
        }

        Text(
            text = state.name,
            color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
        )

        Text(
            text = state.modifiedDate.toString(),
            color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
        )

        Text(
            text = stringResource(R.string.more),
            color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .align(Alignment.End)
                .clickable { onBackClick() },
        )
        Text(
            text = state.description,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
            )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.background(color = Color.Red),
        ) {
            item {
                Text(
                    text = stringResource(R.string.comics),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp),
                )
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp)) {

                }
            }
        }
    }

}
