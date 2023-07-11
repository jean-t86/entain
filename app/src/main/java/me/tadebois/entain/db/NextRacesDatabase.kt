package me.tadebois.entain.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Race::class], version = 1, exportSchema = false)
abstract class NextRacesDatabase : RoomDatabase() {
    abstract fun raceDao(): RaceDao
}
