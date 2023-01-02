package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shamardn.android.marvelcomics.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shamardn.android.marvelcomics.ui.theme.Red500

@Composable
fun ErrorView(
    onClickTryAgain: () -> Unit = {},
    queryText: String? = null,
    onClickTryAgainWithArg: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error))
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().background(color = MaterialTheme.colors.background),
    ) {
        LottieAnimation(composition = composition, iterations = Int.MAX_VALUE,
            modifier = Modifier.size(350.dp))

        Text(
            modifier = Modifier.padding(10.dp)
                .clickable { if(queryText == null) onClickTryAgain() else onClickTryAgainWithArg(queryText) }
                .background(color = Color.Transparent, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp, vertical = 4.dp),
            text = stringResource(R.string.try_again),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Red500,
            textAlign = TextAlign.Center
        )
    }
}