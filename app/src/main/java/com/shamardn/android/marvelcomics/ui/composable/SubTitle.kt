package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun SubTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.Red,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)

    )
}