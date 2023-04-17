package com.yunusemreyildirim.instaclone.view

import android.app.Activity
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
fun FeedPage(context:Activity) {

    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {

            BackHandler {
                if (bottomSheetState.currentValue != ModalBottomSheetValue.Hidden) {
                    scope.launch { bottomSheetState.hide() }
                }
                else{
                    context.finish()
                }
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
            item {
                PostImage {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage {
                    scope.launch { bottomSheetState.show() }
                }
            }
        }
    }
}