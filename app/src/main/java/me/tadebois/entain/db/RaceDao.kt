package me.tadebois.entain.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface RaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(race: Race)

    @Update
    suspend fun updateRace(race: Race)

    @Delete
    suspend fun deleteRace(race: Race)

    @Query("SELECT * FROM races")
    suspend fun getAllRaces(): List<Race>

    @Query("SELECT * FROM races WHERE id = :id")
    suspend fun getRaceById(id: String): Race?
}
