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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoryDetailsUiState

@Composable
fun ItemStory(
    state: StoryDetailsUiState,
    onClickStory: (StoryDetailsUiState) -> Unit,
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClickStory(state) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(color = Color.Red)
                .clip(RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val path = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available"
            val extension = "jpg"
            val img = "$path.$extension"

            Image(
                painter = rememberAsyncImagePainter(model = img),
                contentDescription = "Description",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = state.title,
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
