package me.tadebois.entain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RaceDao {
    @Insert
    suspend fun insert(race: Race)

    @Query("SELECT * FROM races")
    suspend fun getAllRaces(): List<Race>

    @Query("SELECT * FROM races WHERE id = :id")
    suspend fun getRaceById(id: String): Race?
}
