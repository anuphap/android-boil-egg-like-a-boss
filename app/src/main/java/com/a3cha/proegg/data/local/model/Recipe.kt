package com.a3cha.proegg.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.a3cha.proegg.extension.toMinutes

@Entity(tableName = "recipe")
data class Recipe(
        @PrimaryKey val id: String,
        val name: String,
        val shortDescription: String,
        val longDescription: String,
        val time: Long) {

    fun displayTime(): String = "${time.toMinutes()} นาที"
}