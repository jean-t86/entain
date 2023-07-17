package me.tadebois.entain.repository

import kotlinx.coroutines.flow.Flow
import me.tadebois.entain.db.Race
import me.tadebois.entain.db.RaceDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceRepository @Inject constructor(private val raceDao: RaceDao) {
    suspend fun insertRace(race: Race) {
        raceDao.insert(race)
    }

    suspend fun updateRace(race: Race) {
        raceDao.updateRace(race)
    }

    suspend fun deleteRace(race: Race) {
        raceDao.deleteRace(race)
    }

    fun getAllRaces(): Flow<List<Race>> {
        return raceDao.getAllRaces()
    }
}
