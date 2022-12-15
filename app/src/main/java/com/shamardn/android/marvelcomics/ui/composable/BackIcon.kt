package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.ui.theme.Gray200

@Composable
fun BackIcon(modifier: Modifier, onBackClick: () -> Unit) {
    IconButton(
        onClick = onBackClick,
        modifier = Modifier
            .padding(16.dp)
            .clip(shape = CircleShape)
            .background(color = Gray200),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = stringResource(R.string.back_icon),
            tint = Color.White
        )
    }
}