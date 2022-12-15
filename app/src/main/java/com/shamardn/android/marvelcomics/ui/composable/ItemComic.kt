package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.theme.Gray500
import com.shamardn.android.marvelcomics.ui.theme.PrimaryTextColor

@Composable
fun ItemComic(
    state: CharactersDetailsUiState,
    onClick: (CharactersDetailsUiState) -> Unit,
    modifier: Modifier,
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .clickable{ onClick(state) }
                .fillMaxWidth()
                .height(210.dp)
                .background(color = Gray500)
                .clip(RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
            Image(
                painter = rememberAsyncImagePainter(model = img),
                contentDescription = "Description",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = state.name,
                textAlign = TextAlign.Center,
                color = PrimaryTextColor,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }
}
