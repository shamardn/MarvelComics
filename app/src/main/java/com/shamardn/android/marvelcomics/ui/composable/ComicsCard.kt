package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComicsCard(
    title: String,
    image: Painter,
    onClick: () -> Unit,
) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .clickable{ onClick() }
            .fillMaxWidth()
            .height(130.dp)
            .padding(top = 16.dp)
            .clip(shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(108.dp)
                    .background(color = Color.Red)
                    .padding(top = 48.dp)

            )
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
        }
    }
}