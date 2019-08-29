package com.a3cha.proegg.extension

import com.a3cha.proegg.data.Data

fun Long.toMinutes(): String {
    return "${(this / Data.TIME_MINUTE).toInt()}"
}