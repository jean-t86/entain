package me.tadebois.entain.repository

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.tadebois.entain.db.NextRacesDatabase
import me.tadebois.entain.db.Race
import me.tadebois.entain.nedapi.NedApi
import timber.log.Timber
import javax.inject.Inject

@HiltWorker
class DataSyncWorker @AssistedInject constructor(
    @Assisted val appContext: Context,
    @Assisted val params: WorkerParameters,
    private val nedApi: NedApi,
    private val raceRepository: RaceRepository
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        try {
            val races = nedApi.getNextRaces().data.raceSummaries.values.map { raceSummary ->
                Race(
                    raceSummary.raceId,
                    raceSummary.raceName,
                    raceSummary.categoryId,
                    raceSummary.advertisedStart.seconds
                )
            }
            Timber.d("Total races: ${races.count()}")

            // TODO: Implement insertion logic into the database
            raceRepository.insertRace(races[0])

            return Result.success()
        } catch (e: Exception) {
            Timber.e(e.message)
            return Result.failure()
        }
    }
}

