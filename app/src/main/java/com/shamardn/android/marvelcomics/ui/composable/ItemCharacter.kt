package com.shamardn.android.marvelcomics.ui.composable

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import com.shamardn.android.marvelcomics.ui.theme.Red600

@Composable
fun ItemCharacter(
    state: CharacterDetailsUiState,
    onClickCharacter: (CharacterDetailsUiState) -> Unit,
) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(130.dp)
            .clip(CutCornerShape(bottomEnd = 16.dp))
    ) {
        Column(
            modifier = Modifier
                .clickable { onClickCharacter(state) }
                .fillMaxWidth()
                .background(color = Red600),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val img = "${state.thumbnail.path}.${state.thumbnail.extension}"
            ComplexImage(img = img, height = 80)

            Text(
                text = state.title,
                textAlign = TextAlign.Start,
                color = Color.White,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(8.dp)
                    .height(50.dp)
            )
        }
    }
}
