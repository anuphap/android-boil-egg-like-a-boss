package com.a3cha.proegg.extension

import com.a3cha.proegg.data.Data
import java.util.concurrent.TimeUnit


fun Long.toMinutes(): String {
    return "${(this / Data.TIME_MINUTE).toInt()}"
}

fun Long.toTime(): String {

    val minutes = TimeUnit.MILLISECONDS.toMinutes(this) - TimeUnit.HOURS.toMinutes(
        TimeUnit.MILLISECONDS.toHours(
            this
        )
    )
    val second = TimeUnit.MILLISECONDS.toSeconds(this) - TimeUnit.MINUTES.toSeconds(
        TimeUnit.MILLISECONDS.toMinutes(
            this
        )
    )

    return String.format("%02d:%02d", minutes, second)
}