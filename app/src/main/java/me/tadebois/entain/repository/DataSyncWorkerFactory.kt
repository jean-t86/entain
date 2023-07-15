package me.tadebois.entain.repository

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import me.tadebois.entain.nedapi.NedApi
import javax.inject.Inject

class DataSyncWorkerFactory @Inject constructor(
    private val nedApi: NedApi,
    private val raceRepository: RaceRepository
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            DataSyncWorker::class.java.name -> DataSyncWorker(
                appContext,
                workerParameters,
                nedApi,
                raceRepository
            )
            else -> null
        }
    }
}
