package me.tadebois.entain

import me.tadebois.entain.db.Race
import me.tadebois.entain.db.RaceDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceRepository @Inject constructor(private val raceDao: RaceDao) {
    suspend fun getAllRaces(): List<Race> {
        return raceDao.getAllRaces()
    }
}
