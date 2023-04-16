package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    onCommentClick:() -> Unit = {}
) {
    val showImage = remember { mutableStateOf(false) }
    val isCaptionExpanded = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .wrapContentHeight(), shape = RoundedCornerShape(15.dp), elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(start = 12.dp, end = 6.dp, top = 6.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ProfilePhoto()
                    Text(
                        text = "Abdul Cabbar",
                        modifier = Modifier.padding(start = 6.dp),
                        fontSize = 14.sp
                    )
                }
                IconButton(onClick = {
                    //More
                }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "more for post")
                }
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
                if (showImage.value) {
                    Dialog(onDismissRequest = { showImage.value = false }) {
                        AsyncImage(model = photo, contentDescription = "Dialog Image")
                    }
                }

                Spacer(modifier = Modifier.weight(0.04f))
            }
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
                    IconButton(onClick = {
                        onCommentClick()
                    }) {
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 6.dp)
            ) {
                Text(
                    text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.",
                    maxLines = if (isCaptionExpanded.value) Int.MAX_VALUE else 1,
                    modifier = Modifier
                        .clickable {
                            isCaptionExpanded.value = !isCaptionExpanded.value
                        }
                        .weight(0.9f)
                )
                Text(
                    text = "...", color = Color.Gray, modifier = Modifier
                        .weight(0.1f)
                        .alpha(if (isCaptionExpanded.value) 0f else 1f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 6.dp)
            ) {
                Text(text = "5 Comments", fontSize = 10.sp)
                Text(text = "15.04.2023", fontSize = 11.sp)
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

@Composable
fun Comment() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfilePhoto()
            Text(
                text = "username_x",
                modifier = Modifier.padding(start = 6.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının")
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "like comment",
                modifier = Modifier
                    .clickable {

                    }
                    .padding(end = 15.dp), tint = Color.Gray
            )
            Text(
                text = "answer",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 15.dp),
                color = Color.Gray
            )
            Text(text = "Copy", fontWeight = FontWeight.SemiBold, color = Color.Gray)
        }
    }
}

@Composable
fun SubComment() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = 16.dp, bottom = 16.dp, start = 80.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfilePhoto()
            Text(
                text = "username_x",
                modifier = Modifier.padding(start = 6.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının")
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "like comment",
                modifier = Modifier
                    .clickable {

                    }
                    .padding(end = 15.dp), tint = Color.Gray
            )
            Text(
                text = "answer",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 15.dp),
                color = Color.Gray
            )
            Text(text = "Copy", fontWeight = FontWeight.SemiBold, color = Color.Gray)
        }
    }
}