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

public val iconpack.Likeicon: ImageVector
    get() {
        if (_likeicon != null) {
            return _likeicon!!
        }
        _likeicon = Builder(name = "Likeicon", defaultWidth = 25.0.dp, defaultHeight = 25.0.dp,
                viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.75f, 5.4688f)
                curveTo(5.8533f, 5.4688f, 3.3854f, 7.6347f, 3.3854f, 10.4477f)
                curveTo(3.3854f, 12.3883f, 4.2941f, 14.0221f, 5.4984f, 15.3754f)
                curveTo(6.6986f, 16.7242f, 8.2471f, 17.8563f, 9.6469f, 18.8038f)
                lineTo(12.0621f, 20.4386f)
                curveTo(12.3266f, 20.6177f, 12.6734f, 20.6177f, 12.9379f, 20.4386f)
                lineTo(15.3532f, 18.8038f)
                curveTo(16.753f, 17.8563f, 18.3014f, 16.7242f, 19.5016f, 15.3754f)
                curveTo(20.7059f, 14.0221f, 21.6146f, 12.3883f, 21.6146f, 10.4477f)
                curveTo(21.6146f, 7.6347f, 19.1467f, 5.4688f, 16.25f, 5.4688f)
                curveTo(14.7568f, 5.4688f, 13.4429f, 6.1689f, 12.5f, 7.0748f)
                curveTo(11.5571f, 6.1689f, 10.2432f, 5.4688f, 8.75f, 5.4688f)
                close()
            }
        }
        .build()
        return _likeicon!!
    }

private var _likeicon: ImageVector? = null
