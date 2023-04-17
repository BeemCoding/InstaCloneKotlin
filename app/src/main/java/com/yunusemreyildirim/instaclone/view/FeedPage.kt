package com.yunusemreyildirim.instaclone.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yunusemreyildirim.instaclone.component.PostImage
import com.yunusemreyildirim.instaclone.component.StoryAndProfilePhoto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedPage(bottomSheetState: ModalBottomSheetState, scope:CoroutineScope) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item { StoryAndProfilePhoto() }
                item { StoryAndProfilePhoto() }
                item { StoryAndProfilePhoto() }
                item { StoryAndProfilePhoto() }
                item { StoryAndProfilePhoto() }
                item { StoryAndProfilePhoto() }
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
        item {
            PostImage {
                scope.launch { bottomSheetState.show() }
            }
        }
    }
}