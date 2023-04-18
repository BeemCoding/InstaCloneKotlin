package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yunusemreyildirim.instaclone.R
import com.yunusemreyildirim.instaclone.view.navigateAndClean


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Comment(navController: NavHostController) {
    var like by remember{ mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .combinedClickable(onDoubleClick = {like = !like}) {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfilePhoto(imageModifier = Modifier
                .clip(CircleShape)
                .size(30.dp),
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, brush = borderBrush.value, shape = CircleShape)
                    .clickable {
                        navController.navigateAndClean("ProfilePage")
                    })
            Text(
                text = "username_x",
                modifier = Modifier.padding(start = 6.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = if(!like) R.drawable.heart else R.drawable.heart_filled),
                contentDescription = "like comment",
                modifier = Modifier.combinedClickable {
                    like = !like
                }, tint = if(!like) Color.Gray else Color.Red
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "answer",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .clickable {

                    },
                color = Color.Gray, fontSize = 13.sp
            )
            Text(
                text = "copy",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.clickable {

                })
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SubComment(navController: NavHostController) {
    var like by remember{ mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = 16.dp, bottom = 16.dp, start = 80.dp)
            .combinedClickable(onDoubleClick = {like = !like}) {}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfilePhoto(imageModifier = Modifier
                .clip(CircleShape)
                .size(30.dp),
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, brush = borderBrush.value, shape = CircleShape)
                    .clickable {
                        navController.navigateAndClean("ProfilePage")
                    })
            Text(
                text = "username_x",
                modifier = Modifier.padding(start = 6.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {

            Icon(
                painter = painterResource(id = if(!like) R.drawable.heart else R.drawable.heart_filled),
                contentDescription = "like comment",
                modifier = Modifier.combinedClickable {
                    like = !like
                }, tint = if(!like) Color.Gray else Color.Red
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "answer",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .clickable {

                    },
                color = Color.Gray, fontSize = 13.sp
            )
            Text(
                text = "copy",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.clickable {

                })
        }
    }
}