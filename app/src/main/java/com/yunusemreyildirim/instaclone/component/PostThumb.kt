package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostThumb(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = photo, contentDescription = "post thumbnail", modifier = Modifier
            .clip(
                RoundedCornerShape(15.dp)
            ),
        contentScale = ContentScale.Crop,
    )
}

@Preview(name = "PostThumb", showSystemUi = true)
@Composable
private fun PreviewPostThumb() {
    PostThumb()
}