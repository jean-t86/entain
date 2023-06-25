package me.tadebois.entain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    lateinit var nedApi: NedApi

    // Create a CoroutineScope to manage coroutines
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntainTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
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
        Timber.w("Network Layer Under Construction.")
    }

    private fun handleApiResponse(response: ApiResponse) {
        Timber.w("Network Layer Under Construction")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EntainTheme {
        Greeting("Android")
    }
}
