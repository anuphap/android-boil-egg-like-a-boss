package com.a3cha.proegg.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val time: Long
)