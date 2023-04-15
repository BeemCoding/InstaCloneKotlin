package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.yunusemreyildirim.instaclone.R

const val photo =
    "https://firebasestorage.googleapis.com/v0/b/kotlinfirebase-c450f.appspot.com/o/Image%2Fpexels-sultan-raimosan-10477018.jpg?alt=media&token=8b4c3c06-9437-4eb9-9e7a-1dde07673dbf"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostImage(

) {
    val showImage = remember{ mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .wrapContentHeight(), shape = RoundedCornerShape(15.dp), elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfilePhoto()
                Text(
                    text = "Abdul Cabbar",
                    modifier = Modifier.padding(start = 6.dp),
                    fontSize = 14.sp
                )
            }
            Row {
                Spacer(modifier = Modifier.weight(0.04f))
                AsyncImage(
                    model = photo,
                    contentDescription = "post media photo",
                    modifier = Modifier
                        .weight(0.92f)
                        .height(300.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .combinedClickable(onClick = {},
                            onLongClick = {
                                showImage.value = true
                            }, onDoubleClick = {

                            }),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                if(showImage.value){
                    Dialog(onDismissRequest = { showImage.value = false}) {
                        AsyncImage(model = photo, contentDescription = "Dialog Image")
                    }
                }

                Spacer(modifier = Modifier.weight(0.04f))
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "like icon"
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = "comment icon"
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = "share icon"
                        )
                    }
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.save),
                        contentDescription = "save icon"
                    )
                }
            }
        }
    }
}

@Composable
fun ProfilePhoto() {
    val borderBrush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow))
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .border(width = 2.dp, brush = borderBrush, shape = CircleShape)
            .clickable(onClick = {
                //go profile
            }),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = photo,
            contentDescription = "post profile photo",
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp),
            contentScale = ContentScale.Crop
        )
    }

}
