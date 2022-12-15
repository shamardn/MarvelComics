package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
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
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.theme.Red600

@Composable
fun ItemCharacter(
    state: CharactersDetailsUiState,
    onClick: (CharactersDetailsUiState) -> Unit,
    modifier: Modifier,
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clip(CutCornerShape(bottomEnd = 16.dp))
    ) {
        Column(
            modifier = Modifier
                .clickable{ onClick(state) }
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Red600),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
            Image(
                painter = rememberAsyncImagePainter(model = img),
                contentDescription = "Description",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = state.name,
                textAlign = TextAlign.Start,
                color = Color.White,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(16.dp)
                    .height(130.dp)
            )
        }
    }
}
