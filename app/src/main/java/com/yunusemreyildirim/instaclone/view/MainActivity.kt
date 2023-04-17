@file:OptIn(ExperimentalMaterialApi::class)

package com.yunusemreyildirim.instaclone.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yunusemreyildirim.instaclone.R
import com.yunusemreyildirim.instaclone.component.Comment
import com.yunusemreyildirim.instaclone.component.SubComment
import com.yunusemreyildirim.instaclone.ui.theme.InstaCloneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var bottomSheetState: ModalBottomSheetState
    private lateinit var scope: CoroutineScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    bottomSheetState =
                        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
                    scope = rememberCoroutineScope()
                    MainPagesWithScaffold()
                }
            }
        }
    }

    @Composable
    fun Pages() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "FeedPage") {
            composable("FeedPage") {
                FeedPage(bottomSheetState, scope)
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainPagesWithScaffold() {
        val homePageMutable = remember { mutableStateOf(true) }
        val searchPageMutable = remember { mutableStateOf(false) }
        val newPostPageMutable = remember { mutableStateOf(false) }
        val userPageMutable = remember { mutableStateOf(false) }
        val reelsPageMutable = remember { mutableStateOf(false) }
        ModalBottomSheetLayout(
            sheetState = bottomSheetState,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetContent = {

                BackHandler {
                    if (bottomSheetState.currentValue != ModalBottomSheetValue.Hidden) {
                        scope.launch { bottomSheetState.hide() }
                    } else {
                        finish()
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
            Scaffold(bottomBar = {
                BottomAppBar(
                    backgroundColor = MaterialTheme.colors.surface,
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .clip(CircleShape)
                ) {
                    BottomNavigationItem(
                        selected = homePageMutable.value,
                        onClick = {
                            homePageMutable.value = !homePageMutable.value
                        }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = "home icon"
                            )
                        })
                    BottomNavigationItem(
                        selected = searchPageMutable.value,
                        onClick = {
                            searchPageMutable.value = !searchPageMutable.value
                        }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "search icon"
                            )
                        })
                    BottomNavigationItem(
                        selected = newPostPageMutable.value,
                        onClick = {
                            newPostPageMutable.value = !newPostPageMutable.value
                        }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.new_post),
                                contentDescription = "new post icon"
                            )
                        })
                    BottomNavigationItem(
                        selected = reelsPageMutable.value,
                        onClick = {
                            reelsPageMutable.value = !reelsPageMutable.value
                        }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.reels),
                                contentDescription = "reels icon"
                            )
                        })
                    BottomNavigationItem(
                        selected = userPageMutable.value,
                        onClick = {
                            userPageMutable.value = !userPageMutable.value
                        }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = "person icon"
                            )
                        })
                }
            }, content = {
                Pages()
            })
        }
    }
}