package me.tadebois.entain

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.tadebois.entain.db.Race
import me.tadebois.entain.ui.theme.EntainTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntainApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_title),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                NextRaces()
            }
        }
    }
}

@Preview
@Composable
fun EntainPreview() {
    EntainTheme {
        EntainApp()
    }
}

@Composable
fun NextRaces(
    races: List<Race> = listOf(),
    modifier: Modifier = Modifier
) {

}

@Composable
fun NextRace(modifier: Modifier = Modifier.padding(16.dp)) {
    val image = painterResource(id = R.drawable.racing_icon_horse)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.height(60.dp)
        )
        Text(
            text = "R4 Warrnambool".uppercase(), style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(text = "1m 30s")
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NextRacePreview() {
    EntainTheme {
        NextRace()
    }
}
