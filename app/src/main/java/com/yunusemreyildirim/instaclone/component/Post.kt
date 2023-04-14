package com.yunusemreyildirim.instaclone.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yunusemreyildirim.instaclone.iconpack
import com.yunusemreyildirim.instaclone.icons.Commenticon
import com.yunusemreyildirim.instaclone.icons.Likeicon
import com.yunusemreyildirim.instaclone.icons.Save
import com.yunusemreyildirim.instaclone.icons.Shareicon

val photo =
    "https://firebasestorage.googleapis.com/v0/b/kotlinfirebase-c450f.appspot.com/o/Image%2Fpexels-fang-6316461.jpg?alt=media&token=823ceaa1-3a70-4e6b-860f-714b74a61604"

@Composable
fun PostImage(

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .wrapContentHeight(), shape = RoundedCornerShape(15.dp), elevation = 4.dp
    ) {
        Column {
            Row(modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                ProfilePhoto()
                Text(text = "Abdul Cabbar", modifier = Modifier.padding(start = 4.dp), fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
            }
            Row {
                Spacer(modifier = Modifier.weight(0.04f))
                AsyncImage(
                    model = photo,
                    contentDescription = "post media photo",
                    modifier = Modifier
                        .weight(0.92f)
                        .height(300.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.weight(0.04f))
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row() {
                    IconButton(onClick = {  }) {
                        Icon(imageVector = iconpack.Likeicon, contentDescription = "like icon")
                    }
                    IconButton(onClick = {  }) {
                        Icon(imageVector = iconpack.Commenticon, contentDescription = "comment icon")
                    }
                    IconButton(onClick = { }) {
                        Icon(imageVector = iconpack.Shareicon, contentDescription = "share icon")
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = iconpack.Save, contentDescription = "save icon")
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
            .size(46.dp)
            .clip(CircleShape)
            .border(width = 2.dp, brush = borderBrush, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = photo,
            contentDescription = "post profile photo",
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp),
            contentScale = ContentScale.Crop
        )
    }

}