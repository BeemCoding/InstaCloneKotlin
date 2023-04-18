package com.yunusemreyildirim.instaclone.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yunusemreyildirim.instaclone.R
import com.yunusemreyildirim.instaclone.component.PostImage
import com.yunusemreyildirim.instaclone.component.StoryAndProfilePhoto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedPage(navController: NavHostController ,bottomSheetState: ModalBottomSheetState, scope: CoroutineScope) {
    Scaffold(topBar = {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.instagram_text),
                contentDescription = "instagram logo text"
            )
            Row {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.notification_icon),
                        contentDescription = "notifications' icon"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.messages),
                        contentDescription = "messages icon"
                    )
                }
            }
        }
    }, content = {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item { StoryAndProfilePhoto(navController) }
                    item { StoryAndProfilePhoto(navController) }
                    item { StoryAndProfilePhoto(navController) }
                    item { StoryAndProfilePhoto(navController) }
                    item { StoryAndProfilePhoto(navController) }
                    item { StoryAndProfilePhoto(navController) }
                }
            }
            item {
                PostImage(navController = navController) {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage(navController = navController) {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage(navController = navController) {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item {
                PostImage(navController = navController) {
                    scope.launch { bottomSheetState.show() }
                }
            }
            item { 
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    })
}