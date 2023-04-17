package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun StoryAndProfilePhoto(
) {
    val borderBrush = Brush.linearGradient(colors = listOf(Color.Red, Color.Green, Color.Blue))
    Row {
        Spacer(modifier = Modifier.width(6.dp))
        Box(
            modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .border(width = 2.dp, brush = borderBrush, shape = CircleShape)
                .clickable(onClick = {
                    //go profile
                }),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = photo,
                contentDescription = "post profile photo",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(65.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
    }
}

@Preview(name = "StoryAndProfilePhoto")
@Composable
private fun PreviewStoryAndProfilePhoto() {
    StoryAndProfilePhoto()
}