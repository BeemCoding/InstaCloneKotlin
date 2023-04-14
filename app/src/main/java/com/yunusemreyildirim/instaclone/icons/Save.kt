package com.yunusemreyildirim.instaclone.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.yunusemreyildirim.instaclone.iconpack

public val iconpack.Save: ImageVector
    get() {
        if (_save != null) {
            return _save!!
        }
        _save = Builder(name = "Save", defaultWidth = 15.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 15.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.4042f, 6.657f)
                horizontalLineTo(10.1768f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(7.2907f, 1.0f)
                curveTo(1.9122f, 1.0f, 1.0036f, 1.7848f, 1.0036f, 8.0981f)
                curveTo(1.0036f, 15.1659f, 0.8714f, 17.0f, 2.2154f, 17.0f)
                curveTo(3.5585f, 17.0f, 5.7522f, 13.8977f, 7.2907f, 13.8977f)
                curveTo(8.8293f, 13.8977f, 11.0229f, 17.0f, 12.3661f, 17.0f)
                curveTo(13.7101f, 17.0f, 13.5779f, 15.1659f, 13.5779f, 8.0981f)
                curveTo(13.5779f, 1.7848f, 12.6693f, 1.0f, 7.2907f, 1.0f)
                close()
            }
        }
        .build()
        return _save!!
    }

private var _save: ImageVector? = null
