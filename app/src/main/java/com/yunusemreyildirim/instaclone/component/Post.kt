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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.*
import com.yunusemreyildirim.instaclone.R
import com.yunusemreyildirim.instaclone.view.navigateAndClean
import kotlinx.coroutines.delay
import nl.birdly.zoombox.zoomable

const val photo = R.drawable.test_image

// "https://firebasestorage.googleapis.com/v0/b/kotlinfirebase-c450f.appspot.com/o/Image%2Fpexels-sultan-raimosan-10477018.jpg?alt=media&token=8b4c3c06-9437-4eb9-9e7a-1dde07673dbf"
val borderBrush =
    lazy {
        Brush.linearGradient(
            colors = listOf(
                Color(206, 0, 148, 255),
                Color(247, 206, 0),
                Color(0, 64, 255, 255),
            )
        )
    }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostImage(
    navController: NavHostController,
    onCommentClick: () -> Unit = {}
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.heart)
    )
    var like by remember { mutableStateOf(false) }
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
                    ProfilePhoto(
                        imageModifier = Modifier
                            .clip(CircleShape)
                            .size(30.dp),
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .border(width = 2.dp, brush = borderBrush.value, shape = CircleShape)
                            .clickable {
                                navController.navigateAndClean("ProfilePage")
                            }
                    )
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
            Box(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
                AsyncImage(
                    model = photo,
                    contentDescription = "post media photo",
                    modifier = Modifier
                        .height(300.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .combinedClickable(onClick = {},
                            onLongClick = {
                                showImage.value = true
                            }, onDoubleClick = {
                                like = !like
                            }),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                var animationProgress by remember { mutableStateOf(0f) }
                LaunchedEffect(like) {
                    if (like) {
                        animationProgress = 0f
                        while (animationProgress < 1f) {
                            delay(12)
                            animationProgress += 17 / composition!!.duration
                        }
                    }
                }
                if (like) {
                    LottieAnimation(
                        composition,
                        modifier = Modifier
                            .height(300.dp)
                            .alpha(if (animationProgress >= 1f) 0f else 1f)
                    )
                }
                if (showImage.value) {
                    Dialog(onDismissRequest = { showImage.value = false }) {
                        AsyncImage(
                            model = photo,
                            contentDescription = "Dialog Image",
                            modifier = Modifier.fillMaxSize().zoomable()
                        )
                    }
                }
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
                    IconButton(onClick = { like = !like }) {
                        Icon(
                            painter = painterResource(id = if (!like) R.drawable.heart else R.drawable.heart_filled),
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
                    text = "Nulla tempor risus primis, tellus vitae mollis potenti aliquam. Eros sit rhoncus amet, donec quisque cursus, etiam aliquet venenatis felis purus inceptos nisl blandit. Massa neque nibh, rutrum luctus pellentesque senectus vel. Rutrum vel integer cursus, nibh pretium dictum, neque mollis sodales ac nunc elit. Non pharetra euismod, eget fusce purus gravida. Mollis eros turpis sagittis, fringilla ullamcorper elementum, vel vehicula primis purus congue sit velit id.",
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