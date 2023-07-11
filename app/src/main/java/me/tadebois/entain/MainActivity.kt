package me.tadebois.entain

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tadebois.entain.nedapi.ApiResponse
import me.tadebois.entain.nedapi.NedApi
import me.tadebois.entain.ui.theme.EntainTheme
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var raceRepository: RaceRepository
    private val raceViewModel: RaceViewModel by viewModels { RaceViewModelFactory(raceRepository) }

    @Inject
    lateinit var nedApi: NedApi

    // Create a CoroutineScope to manage coroutines
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntainTheme {
                EntainApp()
            }
        }

        coroutineScope.launch {
            try {
                val response = nedApi.getNextRaces()
                // Process the response
                handleApiResponse(response)
            } catch (e: Exception) {
                // Handle the error
                handleError(e)
            }
        }
    }

    private fun handleError(e: Exception) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        Timber.e(e)
    }

    private fun handleApiResponse(response: ApiResponse) {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
    }
}


