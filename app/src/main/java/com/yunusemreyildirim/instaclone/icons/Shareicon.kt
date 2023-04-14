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

public val iconpack.Shareicon: ImageVector
    get() {
        if (_shareicon != null) {
            return _shareicon!!
        }
        _shareicon = Builder(name = "Shareicon", defaultWidth = 32.0.dp, defaultHeight = 33.0.dp,
                viewportWidth = 32.0f, viewportHeight = 33.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(23.7238f, 12.085f)
                curveTo(23.8109f, 11.9332f, 23.8088f, 11.7461f, 23.7184f, 11.5962f)
                curveTo(23.628f, 11.4464f, 23.4634f, 11.3573f, 23.2885f, 11.3636f)
                lineTo(20.7736f, 11.4537f)
                curveTo(15.8189f, 11.6312f, 10.8953f, 12.3145f, 6.0796f, 13.4931f)
                lineTo(5.4272f, 13.6528f)
                curveTo(5.2783f, 13.6892f, 5.1556f, 13.7944f, 5.0968f, 13.9359f)
                curveTo(5.0379f, 14.0775f, 5.05f, 14.2386f, 5.1292f, 14.3699f)
                lineTo(7.9924f, 19.1151f)
                curveTo(8.1248f, 19.3346f, 8.4058f, 19.412f, 8.6319f, 19.2913f)
                lineTo(9.4916f, 18.8324f)
                curveTo(11.5876f, 17.7135f, 13.7729f, 16.7708f, 16.025f, 16.0139f)
                lineTo(16.248f, 15.9389f)
                curveTo(16.2976f, 15.9222f, 16.3274f, 15.9287f, 16.3465f, 15.9365f)
                curveTo(16.3706f, 15.9464f, 16.3977f, 15.9677f, 16.4179f, 16.0013f)
                curveTo(16.4381f, 16.0348f, 16.4444f, 16.0686f, 16.4419f, 16.0946f)
                curveTo(16.4399f, 16.1151f, 16.4317f, 16.1445f, 16.3939f, 16.1806f)
                lineTo(16.2236f, 16.3429f)
                curveTo(14.504f, 17.9825f, 12.6512f, 19.4763f, 10.6842f, 20.809f)
                lineTo(9.8775f, 21.3556f)
                curveTo(9.6653f, 21.4993f, 9.6028f, 21.784f, 9.7352f, 22.0035f)
                lineTo(12.5984f, 26.7487f)
                curveTo(12.6776f, 26.88f, 12.8145f, 26.9657f, 12.9672f, 26.9797f)
                curveTo(13.1199f, 26.9936f, 13.2701f, 26.9341f, 13.3717f, 26.8193f)
                lineTo(13.8171f, 26.3166f)
                curveTo(17.1049f, 22.6057f, 20.0048f, 18.5685f, 22.4717f, 14.2679f)
                lineTo(23.7238f, 12.085f)
                close()
            }
        }
        .build()
        return _shareicon!!
    }

private var _shareicon: ImageVector? = null
