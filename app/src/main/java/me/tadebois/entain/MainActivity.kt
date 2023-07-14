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
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val raceViewModel: RaceViewModel by viewModels()

    @Inject
    lateinit var nedApi: NedApi
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

        raceViewModel.updatedRaces.observe(this) { races ->
            print("There are ${races.count()} races")
        }
    }

    private fun print(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    private fun handleError(e: Exception) = print(e.message)

    private fun handleApiResponse(response: ApiResponse) = print(response.message)
}
