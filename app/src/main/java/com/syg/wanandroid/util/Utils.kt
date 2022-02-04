package com.syg.wanandroid.util

import android.content.res.Resources

fun dp2px(dipValue: Float): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}