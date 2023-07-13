package me.tadebois.entain

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tadebois.entain.db.Race
import me.tadebois.entain.nedapi.ApiResponse
import me.tadebois.entain.nedapi.NedApi
import me.tadebois.entain.ui.theme.EntainTheme
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val raceViewModel: RaceViewModel by viewModels()

    @Inject
    lateinit var nedApi: NedApi

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            EntainTheme {
//                EntainApp()
//            }
//        }

//        addRace()

        setContent {
            EntainTheme {
                RaceListScreen()
            }
        }

//        addRace()

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

    private fun addRace() {
        raceViewModel.addRace(
            Race(
                "${Random.nextInt()}",
                "R1",
                "category_id",
                System.currentTimeMillis()
            )
        )
    }

    private fun handleError(e: Exception) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        Timber.e(e)
    }

    private fun handleApiResponse(response: ApiResponse) {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
    }

    @Composable
    fun RaceListScreen() {
        val races = raceViewModel.races

//        LaunchedEffect(races) {
//            val test = races.toList()
//            // Observe changes in races
//            // Update your UI accordingly
//            Timber.d("Watched: RaceListScreen: ${races.count()}")
//        }

        Scaffold(
            content = { padding ->
                Timber.d("Watched: RaceList call from RaceListScreen: ${races.count()}")
                Column(Modifier.padding(padding), verticalArrangement = Arrangement.SpaceBetween) {
                    RaceList(races)
                    Bob()
                }
            }
        )
    }

    @Composable
    fun Bob() {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "I do not get recompose")
        }
    }

    @Composable
    fun RaceList(races: SnapshotStateList<Race>) {
        Button(onClick = {
            addRace()
//            raceViewModel.getAllRaces()
        }) {
            Text(text = "Test: ${races.count()}")
        }
        // Display the list of races
        // You can use a LazyColumn, RecyclerView, or any other Composable to display the races
        Timber.d("Watched: RaceList Composable: ${races.count()}")
    }

    @Preview
    @Composable
    fun previewRaceScreen() {
        EntainTheme {
            RaceListScreen()
        }
    }
}




