package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostImage(

) {
    val profilePhotoUrl =
        "https://images.pexels.com/photos/14844108/pexels-photo-14844108.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 3.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column() {
            Row() {
                AsyncImage(
                    model = profilePhotoUrl,
                    contentDescription = "post profile photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(434.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )


            }
            Row() {

            }
            Row() {

            }
        }
    }
}

@Preview(name = "Post", showSystemUi = true)
@Composable
private fun PreviewPost() {
    PostImage()
}