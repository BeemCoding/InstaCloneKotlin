package com.yunusemreyildirim.instaclone.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.yunusemreyildirim.instaclone.component.PostImage

@Composable
fun FeedPage() {
    LazyColumn {
        item { PostImage() }
        item { PostImage() }
        item { PostImage() }
    }
}