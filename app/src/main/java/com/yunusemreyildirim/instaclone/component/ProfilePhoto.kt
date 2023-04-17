package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ProfilePhoto(boxModifier:Modifier,imageModifier: Modifier) {
    Box(
        modifier = boxModifier,
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