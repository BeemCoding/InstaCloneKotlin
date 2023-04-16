package com.yunusemreyildirim.instaclone.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.yunusemreyildirim.instaclone.component.PostImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedPage() {
    BottomSheetScaffold(sheetContent = {

    }) {
        LazyColumn {
            item { PostImage() }
            item { PostImage() }
            item { PostImage() }
        }
    }
}