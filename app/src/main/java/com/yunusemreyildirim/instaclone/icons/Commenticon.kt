package com.yunusemreyildirim.instaclone.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.yunusemreyildirim.instaclone.iconpack

public val iconpack.Commenticon: ImageVector
    get() {
        if (_commenticon != null) {
            return _commenticon!!
        }
        _commenticon = Builder(name = "Commenticon", defaultWidth = 27.0.dp, defaultHeight =
                27.0.dp, viewportWidth = 27.0f, viewportHeight = 27.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.906f, 4.5f)
                curveTo(7.4032f, 4.5f, 2.9728f, 11.089f, 5.4263f, 17.1111f)
                lineTo(6.4752f, 19.6857f)
                curveTo(6.569f, 19.916f, 6.5004f, 20.1807f, 6.3065f, 20.3365f)
                lineTo(4.0886f, 22.1177f)
                curveTo(3.9024f, 22.2671f, 3.8309f, 22.5178f, 3.9102f, 22.7429f)
                curveTo(3.9894f, 22.9681f, 4.2021f, 23.1187f, 4.4408f, 23.1187f)
                horizontalLineTo(13.2386f)
                curveTo(18.6642f, 23.1187f, 23.0625f, 18.7204f, 23.0625f, 13.2949f)
                curveTo(23.0625f, 8.4376f, 19.1249f, 4.5f, 14.2676f, 4.5f)
                horizontalLineTo(13.906f)
                close()
            }
        }
        .build()
        return _commenticon!!
    }

private var _commenticon: ImageVector? = null
