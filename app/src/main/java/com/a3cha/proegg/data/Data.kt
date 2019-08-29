package com.a3cha.proegg.data

import com.a3cha.proegg.data.local.model.Recipe

object Data {
    const val TIME_SECOND = 1000L
    const val TIME_MINUTE = 60L * TIME_SECOND

    fun defaultRecipes() = listOf(
        Recipe(
            id = "1",
            name = "ไข่แดงยางมะตูม",
            time = 4 * TIME_MINUTE,
            description = "ไข่แดงยางมะตูม\nTIP : สำหรับการต้มไข่เป็ด ให้บวกเวลาของแต่ละขั้นที่ต้องการเข้าไป 2 นาที"),
        Recipe(
            id = "2",
            name = "ไข่แดงสีส้มเกือบสุก",
            time = 6 * TIME_MINUTE,
            description = "ไข่ต้มสุก ไข่แดงเป็นสีส้มเกือบสุก\nTIP : สำหรับการต้มไข่เป็ด ให้บวกเวลาของแต่ละขั้นที่ต้องการเข้าไป 2 นาที"),
        Recipe(
            id = "3",
            name = "ไข่แดงสุกพอดี",
            time = 8 * TIME_MINUTE,
            description = "ไข่ต้มสุกทั้งใบ ไข่แดงเป็นสีส้ม \n TIP : สำหรับการต้มไข่เป็ด ให้บวกเวลาของแต่ละขั้นที่ต้องการเข้าไป 2 นาที"),
        Recipe(
            id = "4",
            name = "ไข่แดงสุกมาก",
            time = 10 * TIME_MINUTE,
            description = "ไข่ต้มสุกมากทั้งใบ ไข่แดงสุกมาก \n TIP : สำหรับการต้มไข่เป็ด ให้บวกเวลาของแต่ละขั้นที่ต้องการเข้าไป 2 นาที")
    )
}