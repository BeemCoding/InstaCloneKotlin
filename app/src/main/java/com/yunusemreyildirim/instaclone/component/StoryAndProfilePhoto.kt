package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun StoryAndProfilePhoto(
    navController: NavHostController
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Spacer(modifier = Modifier.width(6.dp))
            ProfilePhoto(
                modifier = Modifier
                    .size(76.dp)
                    .clip(CircleShape)
                    .border(width = 3.dp, brush = borderBrush.value, shape = CircleShape)
                    .clickable(
                        onClick = {
                            //Go Story
                        }
                    ),
                imageModifier = Modifier
                    .clip(CircleShape)
                    .size(69.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
        }
        Text(text = "username_x", fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp))
    }
}