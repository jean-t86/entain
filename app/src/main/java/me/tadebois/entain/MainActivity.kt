package me.tadebois.entain

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.AndroidEntryPoint
import me.tadebois.entain.repository.DataSyncWorker
import me.tadebois.entain.ui.theme.EntainTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val raceViewModel: RaceViewModel by viewModels()

    private val workManager: WorkManager by lazy { WorkManager.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntainTheme {
                EntainApp()
            }
        }

        raceViewModel.updatedRaces.observe(this) { races ->
            print("There are ${races.count()} races")
        }
    }

    override fun onStart() {
        super.onStart()
        enqueueDataSyncWorker()
    }

    private fun enqueueDataSyncWorker() {
        val workRequest = OneTimeWorkRequestBuilder<DataSyncWorker>().build()
        workManager.enqueue(workRequest)
    }

    private fun print(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
