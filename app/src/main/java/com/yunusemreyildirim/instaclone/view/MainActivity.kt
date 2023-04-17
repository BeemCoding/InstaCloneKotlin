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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
    private lateinit var selectedItem: MutableState<Int>
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
                    val navController = rememberNavController()
                    MainPagesWithScaffold(navController)
                }
            }
        }
    }

    @Composable
    fun Pages(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "FeedPage") {
            composable("FeedPage") {
                selectedItem.value = 1
                FeedPage(navController ,bottomSheetState, scope)
            }
            composable("SearchPage") {
                selectedItem.value = 2
                Text(text = "Search Page")
            }
            composable("NewPostPage") {
                selectedItem.value = 3
                Text(text = "New Post Page")
            }
            composable("ReelsPage") {
                selectedItem.value = 4
                Text(text = "Reels Page")
            }
            composable("ProfilePage") {
                selectedItem.value = 5
                Text(text = "Profile Page")
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainPagesWithScaffold(navController: NavHostController) {
        selectedItem = remember { mutableStateOf(1) }
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
                    item { Comment(navController) }
                    item { Comment(navController) }
                    item { SubComment(navController) }
                    item { SubComment(navController) }
                    item { Comment(navController) }
                    item { Comment(navController) }
                    item { SubComment(navController) }
                }
            },
        ) {
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        backgroundColor = MaterialTheme.colors.surface,
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .clip(CircleShape)
                    ) {
                        for (item in 1..5) {
                            BottomNavigationItem(
                                modifier = Modifier,
                                selected = selectedItem.value == item,
                                onClick = {
                                    selectedItem.value = item
                                    when (selectedItem.value) {
                                        1 -> navController.navigateAndClean("FeedPage")
                                        2 -> navController.navigateAndClean("SearchPage")
                                        3 -> navController.navigateAndClean("NewPostPage")
                                        4 -> navController.navigateAndClean("ReelsPage")
                                        5 -> navController.navigateAndClean("ProfilePage")
                                    }
                                },
                                icon = {
                                    when (item) {
                                        1 -> {
                                            Icon(
                                                painterResource(id = R.drawable.home),
                                                contentDescription = "home page"
                                            )
                                        }
                                        2 -> {
                                            Icon(
                                                painterResource(id = R.drawable.search),
                                                contentDescription = "search page"
                                            )
                                        }
                                        3 -> {
                                            Icon(
                                                painterResource(id = R.drawable.new_post),
                                                contentDescription = "new post page"
                                            )
                                        }
                                        4 -> {
                                            Icon(
                                                painterResource(id = R.drawable.reels),
                                                contentDescription = "reels page"
                                            )
                                        }
                                        5 -> {
                                            Icon(
                                                painterResource(id = R.drawable.person),
                                                contentDescription = "profile page"
                                            )
                                        }
                                    }
                                }
                            )
                        }
                    }
                }, content = {
                    Pages(navController = navController)
                })
        }
    }
}

fun NavController.navigateAndClean(route: String) {
    navigate(route = route) {
        popUpTo(graph.startDestinationId) { inclusive = true }
    }
    graph.setStartDestination(route)
}