package com.yunusemreyildirim.instaclone.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import com.yunusemreyildirim.instaclone.component.Comment
import com.yunusemreyildirim.instaclone.component.PostImage
import com.yunusemreyildirim.instaclone.component.SubComment
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, DelicateCoroutinesApi::class)
@Composable
fun FeedPage() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(scaffoldState = bottomSheetScaffoldState, sheetContent = {
        LazyColumn{
            item { Comment() }
            item { Comment() }
            item { SubComment() }
            item { SubComment() }
            item { Comment() }
            item { Comment() }
            item { SubComment() }
        }
    },) {
        LazyColumn {
            item { PostImage(onCommentClick = {
                GlobalScope.launch {
                    bottomSheetScaffoldState.bottomSheetState.expand()
                }
            }) }
            item { PostImage() }
            item { PostImage() }
            item{ PostImage() }
        }
    }
}