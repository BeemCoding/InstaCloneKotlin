package com.yunusemreyildirim.instaclone

import androidx.compose.ui.graphics.vector.ImageVector
import com.yunusemreyildirim.instaclone.icons.Commenticon
import com.yunusemreyildirim.instaclone.icons.Likeicon
import com.yunusemreyildirim.instaclone.icons.Save
import com.yunusemreyildirim.instaclone.icons.Saved
import com.yunusemreyildirim.instaclone.icons.Shareicon
import kotlin.collections.List as ____KtList

public object iconpack

private var __AllIcons: ____KtList<ImageVector>? = null

public val iconpack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Commenticon, Likeicon, Save, Saved, Shareicon)
    return __AllIcons!!
  }
