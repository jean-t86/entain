package me.tadebois.entain

import android.app.Application
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.HiltAndroidApp
import me.tadebois.entain.repository.DataSyncWorker
import me.tadebois.entain.repository.DataSyncWorkerFactory
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject
    lateinit var dataSyncWorkerFactory: DataSyncWorkerFactory

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        scheduleDataSync()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(dataSyncWorkerFactory)
            .build()
    }

    private fun scheduleDataSync() {
        val workRequest = OneTimeWorkRequestBuilder<DataSyncWorker>().build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)
    }
}
