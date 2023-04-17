package com.yunusemreyildirim.instaclone.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yunusemreyildirim.instaclone.R
import com.yunusemreyildirim.instaclone.ui.theme.InstaCloneTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
                FeedPage(context = this@MainActivity)
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainPagesWithScaffold() {
        Scaffold(bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .clip(CircleShape)
            ) {
                BottomNavigationItem(selected = true, onClick = {

                }, icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "home icon"
                    )
                })
                BottomNavigationItem(selected = false, onClick = {

                }, icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "home icon"
                    )
                })
                BottomNavigationItem(selected = false, onClick = {

                }, icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "home icon"
                    )
                })
            }
        }, content = {
            Pages()
        })
    }
}