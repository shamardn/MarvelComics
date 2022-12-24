package com.shamardn.android.marvelcomics.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.shamardn.android.marvelcomics.R

@Composable
fun ComplexImage(img: String, height: Int) {
    val imageRequest: ImageRequest = ImageRequest.Builder(LocalContext.current)
        .data(img)
        .crossfade(true)
        .crossfade(1000)
        .placeholder(R.drawable.placeholder)
        .build()

    SubcomposeAsyncImage(
        model = imageRequest,
        contentDescription = "Description",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
    ){
        val  asyncImagePainterState = painter.state
        if (asyncImagePainterState is AsyncImagePainter.State.Loading || asyncImagePainterState is AsyncImagePainter.State.Error) {
//            CircularProgressIndicator()
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}