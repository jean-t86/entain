package me.tadebois.entain.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "races")
data class Race(
    @PrimaryKey
    val id: String,
    val race: String,
    val categoryId: String,
    val advertisedStart: Long
)
