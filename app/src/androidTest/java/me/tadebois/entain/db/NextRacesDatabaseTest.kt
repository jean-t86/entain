package me.tadebois.entain.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NextRacesDatabaseTest {
    private lateinit var nextRacesDatabase: NextRacesDatabase
    private lateinit var raceDao: RaceDao

    @Before
    fun setup() {
        nextRacesDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NextRacesDatabase::class.java
        ).allowMainThreadQueries().build()
        raceDao = nextRacesDatabase.raceDao()
    }

    @After
    fun cleanup() {
        nextRacesDatabase.close()
    }

    @Test
    fun insertAndGetAllRaces() = runBlocking {
        val race1 = Race(
            id = "ad5eb570-cdcb-48e8-8aa1-d2c2c5f18b99",
            race = "R1 NORTHFIELD PARK",
            category_id = "161d9be2-e909-4326-8c2c-35ed71fb460b",
            advertisedStart = System.currentTimeMillis()
        )
        val race2 = Race(
            id = "cbedc67a-5076-4be0-8228-ca0354f451a7",
            race = "R2 YONKERS RACEWAY",
            category_id = "161d9be2-e909-4326-8c2c-35ed71fb460b",
            advertisedStart = System.currentTimeMillis()
        )
        raceDao.insert(race1)
        raceDao.insert(race2)

        val races = raceDao.getAllRaces()

        assertEquals(2, races.size)
        assertEquals(race1, races[0])
        assertEquals(race2, races[1])
    }
}
