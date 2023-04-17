package com.yunusemreyildirim.instaclone.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.yunusemreyildirim.instaclone.component.Comment
import com.yunusemreyildirim.instaclone.component.PostImage
import com.yunusemreyildirim.instaclone.component.SubComment
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedPage() {

    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            BackHandler {
                scope.launch { bottomSheetState.hide() }
            }
            LazyColumn {
                item { Comment() }
                item { Comment() }
                item { SubComment() }
                item { SubComment() }
                item { Comment() }
                item { Comment() }
                item { SubComment() }
            }
        },
    ) {
        LazyColumn {
            item { PostImage{
                scope.launch { bottomSheetState.show() }
            } }
            item { PostImage{
                scope.launch { bottomSheetState.show() }
            } }
            item { PostImage{
                scope.launch { bottomSheetState.show() }
            } }
            item{ PostImage{
                scope.launch { bottomSheetState.show() }
            } }
        }
    }
}