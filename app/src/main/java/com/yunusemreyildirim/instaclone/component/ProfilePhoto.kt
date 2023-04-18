package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


@Composable
fun ProfilePhoto(modifier:Modifier,imageModifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = imageModifier,
            model = photo,
            contentDescription = "post profile photo",
            contentScale = ContentScale.Crop
        )
    }

}