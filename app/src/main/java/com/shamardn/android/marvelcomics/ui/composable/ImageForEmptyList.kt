package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shamardn.android.marvelcomics.R


@Composable
fun ImageForEmptyList(
    modifier: Modifier = Modifier,

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().background(color = MaterialTheme.colors.background)
            .padding(vertical = 64.dp)

    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            text = stringResource(R.string.no_items),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onSecondary,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.empty_page),
            contentDescription = null,
            modifier = Modifier.size(240.dp)

        )

        HyperlinkText(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            fullText = stringResource(R.string.go_back),
            fontSize = 12.sp,
            linkText = listOf("search"),
            hyperlinks = listOf("https://marvel.com/search"),
        )
    }
}